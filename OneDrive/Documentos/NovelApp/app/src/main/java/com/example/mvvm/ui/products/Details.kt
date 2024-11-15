package com.example.mvvm.ui.products

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvm.navigation.ROUTE_HOME
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_VIEW
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(productId: String, navController: NavController) {
    var product by remember { mutableStateOf<Product?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    val firestore = FirebaseFirestore.getInstance()

    // Fetch product details from Firestore using product ID
    LaunchedEffect(productId) {
        firestore.collection("products").document(productId)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                product = documentSnapshot.toObject(Product::class.java)
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }

    // Scaffold to manage layout and bottom navigation


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF9F2B68), shape = RoundedCornerShape(0.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                } else if (product == null) {
                    Text(text = "Product not found", fontSize = 20.sp, color = Color.White)
                } else {
                    ProductDetails(product!!)
                }
            }
        }


@Composable
fun ProductDetails(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 30.dp),

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
                    .clip(RoundedCornerShape(16.dp))  // Apply rounded corners for image
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product Title
        Text(text = product.name, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)

        Spacer(modifier = Modifier.height(8.dp))

        // Price
        Text(text = "Price: ${product.price}", fontSize = 20.sp, fontWeight = FontWeight.Medium, color = Color(0xFFF8C8DC))

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = product.description,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Author
        Text(text = "By: ${product.author}", fontSize = 14.sp, color = Color(0xFFF8C8DC))
    }
}

