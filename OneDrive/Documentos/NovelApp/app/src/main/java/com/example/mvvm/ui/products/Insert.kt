package com.example.mvvm.ui.products


import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvm.navigation.ROUTE_HOME
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_LIBRARY
import com.example.mvvm.navigation.ROUTE_VIEW
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InsertProductsScreen(navController: NavController) {
    var productName by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }
    var uploading by remember { mutableStateOf(false) }

    val firestore = FirebaseFirestore.getInstance()
    val storage = FirebaseStorage.getInstance().reference
    val context = LocalContext.current

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? -> productImageUri = uri }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("", color = Color.White) },
                backgroundColor = Color(0xFF9F2B68),
                elevation = 12.dp,
                modifier = Modifier
                    .height(80.dp)
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFF9F2B68),)
                    .fillMaxSize()
                    .padding(top = 30.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Form Inputs
                Text("Insert Product", fontSize = 24.sp, color = Color.White)

                OutlinedTextField(
                    value = productName,
                    onValueChange = { productName = it },
                    label = { Text("Book Name", color = Color(0xFFF8C8DC)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF9F2B68),
                        unfocusedContainerColor = Color(0xFF9F2B68),
                        focusedIndicatorColor = Color(0xFFF8C8DC),
                        unfocusedIndicatorColor = Color.White,
                        unfocusedTextColor = Color(0xFFF8C8DC),
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = author,
                    onValueChange = { author = it },
                    label = { Text("Author", color = Color(0xFFF8C8DC)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF9F2B68),
                        unfocusedContainerColor = Color(0xFF9F2B68),
                        focusedIndicatorColor = Color(0xFFF8C8DC),
                        unfocusedIndicatorColor = Color.White,
                        unfocusedTextColor = Color(0xFFF8C8DC),
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = productPrice,
                    onValueChange = { productPrice = it },
                    label = { Text("Book Price", color = Color(0xFFF8C8DC)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF9F2B68),
                        unfocusedContainerColor = Color(0xFF9F2B68),
                        focusedIndicatorColor = Color(0xFFF8C8DC),
                        unfocusedIndicatorColor = Color.White,
                        unfocusedTextColor = Color(0xFFF8C8DC),
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = productDescription,
                    onValueChange = { productDescription = it },
                    label = { Text("Book Description", color = Color(0xFFF8C8DC)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF9F2B68),
                        unfocusedContainerColor = Color(0xFF9F2B68),
                        focusedIndicatorColor = Color(0xFFF8C8DC),
                        unfocusedIndicatorColor = Color.White,
                        unfocusedTextColor = Color(0xFFF8C8DC),
                        focusedTextColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { imagePickerLauncher.launch("image/*") },
                    modifier = Modifier.width(250.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp, pressedElevation = 6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF9F2B68))
                ) {
                    Text("Select Book Image", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }

                productImageUri?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = rememberImagePainter(it),
                        contentDescription = "Selected Book Image",
                        modifier = Modifier.size(150.dp).padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (productName.isNotEmpty() && author.isNotEmpty() && productPrice.isNotEmpty() && productDescription.isNotEmpty() && productImageUri != null) {
                            uploading = true
                            uploadProduct(
                                productName, author, productPrice, productDescription,
                                productImageUri!!, storage, firestore, context, navController
                            ) { success ->
                                uploading = false
                                if (success) {
                                    Toast.makeText(context, "Product added successfully!", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Failed to add product", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    },
                    enabled = !uploading,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp, pressedElevation = 6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF9F2B68))
                ) {
                    if (uploading) {
                        CircularProgressIndicator(color = Color.White)
                    } else {
                        Text("Upload Book", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                elevation = 10.dp,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
                    .padding(bottom = 0.dp),
                backgroundColor = Color(0xFF9F2B68)


            ) {
                BottomNavigationItem(
                    icon = {
                        androidx.compose.material3.Icon(imageVector = Icons.Default.Home, "",
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
                        androidx.compose.material3.Icon(imageVector = Icons.Default.Menu, "",
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
                        androidx.compose.material3.Icon(imageVector = Icons.Default.Add, "",
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


fun uploadProduct(
    name: String,
    author: String,
    price: String,
    description: String,
    imageUri: Uri,
    storageReference: StorageReference,
    firestore: FirebaseFirestore,
    context: android.content.Context,
    navController: NavController,
    onComplete: (Boolean) -> Unit
) {
    val storageRef = storageReference.child("products/${imageUri.lastPathSegment}")
    val uploadTask = storageRef.putFile(imageUri)

    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        storageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            val product = hashMapOf(
                "name" to name,
                "author" to author,
                "price" to price,
                "description" to description,
                "image" to downloadUri.toString()
            )

            firestore.collection("products").add(product)
                .addOnSuccessListener {
                    onComplete(true)
                    navController.navigate(ROUTE_HOME)
                }
                .addOnFailureListener {
                    onComplete(false)
                }
        } else {
            onComplete(false)
        }
    }
}
