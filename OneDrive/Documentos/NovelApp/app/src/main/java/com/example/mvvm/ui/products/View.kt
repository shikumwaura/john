package com.example.mvvm.ui.products


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvm.navigation.ROUTE_HOME
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_LIBRARY
import com.example.mvvm.navigation.ROUTE_VIEW
import com.google.firebase.firestore.FirebaseFirestore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewProductsScreen(navController: NavController) {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isEmpty by remember { mutableStateOf(false) }

    val firestore = FirebaseFirestore.getInstance()

    // Fetch products from Firestore
    LaunchedEffect(Unit) {
        firestore.collection("products")
            .get()
            .addOnSuccessListener { querySnapshot ->
                val fetchedProducts = querySnapshot.documents.mapNotNull { document ->
                    document.toObject(Product::class.java)?.apply {
                        id = document.id  // Assign document ID to product
                    }
                }
                products = fetchedProducts
                isLoading = false
                isEmpty = fetchedProducts.isEmpty()
            }
            .addOnFailureListener {
                isLoading = false
            }
    }

    // Scaffold to manage layout and bottom navigation
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("", color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier
                    ) },
                backgroundColor = Color(0xFF9F2B68),
                elevation = 12.dp,
                modifier = Modifier
                    .height(90.dp)
            )
        },


        content = {


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 50.dp)
                            .padding(0.dp)
                            .background(color = Color(0xFF9F2B68),)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(Modifier.height(15.dp))
                        if (isLoading) {
                            CircularProgressIndicator()
                        } else if (isEmpty) {
                            Text(text = "No products found", fontSize = 20.sp, color = Color.White)
                        } else {
                            // LazyGrid with 2 columns
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2), // 2 columns grid
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(products) { product ->
                                    ProductItem(product) {
                                        navController.navigate("details/${product.id}")  // Navigate to details screen with product ID
                                    }
                                }
                            }
                        }
                    }


        },
        bottomBar = {
            BottomNavigation(
                elevation = 10.dp,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars).padding(bottom = 0.dp),
                backgroundColor = Color(0xFF9F2B68)



            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Home, "",
                            tint = Color.White)
                    },
                    label = { Text(text = "Home", color = Color.White) },
                    selected = false,  // Modify based on your selected index logic
                    onClick = {
                        navController.navigate(ROUTE_LIBRARY)
                    }
                )

                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Menu, "",
                            tint = Color.White)
                    },
                    label = { Text(text = "Library", color = Color.White) },
                    selected = false,  // Modify based on your selected index logic
                    onClick = {
                        navController.navigate(ROUTE_VIEW)
                    }
                )

                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Add, "",
                            tint = Color.White)
                    },
                    label = { Text(text = "Insert", color = Color.White) },
                    selected = false,  // Modify based on your selected index logic
                    onClick = {
                        navController.navigate(ROUTE_INSERT)
                    }
                )
            }
        }
    )
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            product.image?.let {
                Image(
                    painter = rememberImagePainter(it),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = product.name, fontSize = 18.sp, color = Color(0xFF9F2B68))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Price: ${product.price}", fontSize = 16.sp, color =  Color(0xFFF8C8DC))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.description, fontSize = 14.sp, color =  Color(0xFF9F2B68))
        }
    }
}

// Product data class
data class Product(
    var id: String = "",
    var author: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val image: String? = null
)
