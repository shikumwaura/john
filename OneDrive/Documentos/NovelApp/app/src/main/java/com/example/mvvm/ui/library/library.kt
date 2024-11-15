package com.example.mvvm.ui.library

import android.annotation.SuppressLint
import android.content.Intent
import android.view.RoundedCorner
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mvvm.R
import com.example.mvvm.navigation.ROUTE_LIBRARY
import com.example.mvvm.navigation.ROUTE_DETAILS
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_VIEW

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.movableContentOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mvvm.navigation.ROUTE_HOME

//import androidx.compose.material.*








@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Library(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("", color = Color.White) },
                backgroundColor = Color(0xFF9F2B68),
                elevation = 12.dp,
                modifier = Modifier
                    .height(70.dp)
            )
        },
        content = {

            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                item {
//
                    val myCustomColor = Color(0xFF9F2B68)
                    Box(
                        modifier = Modifier .fillMaxSize()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .padding(0.dp)
                                .height(1050.dp)
                                .background(color = Color(0xFF9F2B68) ,shape = RoundedCornerShape(20.dp))
                                .padding(0.dp)
                                .fillMaxWidth()
                        )
                        {

                            Row(
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier
                                    .padding( top=30.dp)



                            ) {

                                Text(
                                    text = "Explore Books",
                                    style = MaterialTheme.typography.headlineLarge,
                                    modifier = Modifier.padding(top=50.dp),
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold

                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            )
                            {
//                                Box(
//                                    modifier = Modifier
////                                    .padding(20.dp)
//                                    .clip(CircleShape)
//                                ){

                                val textFieldState= remember {
                                    mutableStateOf("")
                                }
                                TextField(
                                    value = "",
                                    onValueChange = {},
                                    placeholder = { Text("Search books here",
                                        Modifier.padding(0.dp),
                                        color = Color(0xFF9F2B68,
                                        )
                                    ) },
                                    leadingIcon = {
                                        Icon(Icons.Filled.Search,
                                            contentDescription = "null",
                                            tint = Color(0xFF9F2B68))
                                    },
//                                    shape = RoundedCornerShape(35.dp),

                                    modifier = Modifier
                                        .size(width =300.dp, height = 70.dp)
                                        .clip(RoundedCornerShape(40.dp))
                                        .padding(10.dp)
//                                              .background(color = Color(0xFFF8C8DC))
                                        .border(2.dp, Color(0xFFF8C8DC))
                                )

//                            }
                            }
                        }

//                            Spacer(modifier = Modifier.height(200.dp))

                        Row (
                            modifier = Modifier
                                .padding(top = 190.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .background(color = Color(0xFF9F2B68),)

                        ){

                            Row(Modifier.fillMaxSize()
                                .padding(2.dp)) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    val color = Color(0xFFFFCCCC)
                                    Card(
                                        modifier = Modifier
                                            .height(460.dp)
                                            .fillMaxWidth()
                                            .shadow(
                                                elevation = 8.dp,
                                                shape = RoundedCornerShape(20.dp)
                                            ),
                                        elevation = CardDefaults.cardElevation(0.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFF8C8DC)
                                        )
                                    ) {
                                        Row {
                                            Text(
                                                text = "Genres",
                                                letterSpacing = TextUnit(1.0F, TextUnitType.Sp),
                                                style = MaterialTheme.typography.headlineMedium,
                                                modifier = Modifier.padding(6.dp),
                                                color = Color.White,
                                                fontWeight = FontWeight.SemiBold

                                            )
                                        }
                                        LazyRow {
                                            item {
                                                Row {
                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.rom),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )
                                                            // will display in the middle of the image
                                                            Text(
                                                                "Love",
                                                                letterSpacing = TextUnit(0.3F, TextUnitType.Sp),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )

                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.mystery),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )
                                                            // will display in the middle of the image
                                                            Text(
                                                                "Mystery",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }
                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.dramas),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )

                                                            // will display in the middle of the image
//                        val myCustomColor = Color(0xFF9F2B68)
                                                            Text(
                                                                "Drama",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.fantasy),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )
                                                            // will display in the middle of the image
                                                            Text(
                                                                "Fantasy",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {

                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.humor),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )

                                                            // will display in the middle of the image
                                                            Text(
                                                                "Humor",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.thriller),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )

                                                            // will display in the middle of the image
                                                            Text(
                                                                "Thriller",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.horror),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )
                                                            // will display in the middle of the image
                                                            Text(
                                                                "Horror",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }

                                                    Card(
                                                        border = BorderStroke(2.dp, Color.White),
                                                        modifier = Modifier
                                                            .clickable { navController.navigate(ROUTE_VIEW) }
                                                            .padding(10.dp)
                                                            .height(100.dp)
                                                            .width(70.dp)
                                                            .shadow(
                                                                elevation = 8.dp,
                                                                shape = RoundedCornerShape(4.dp)
                                                            ),
                                                        elevation = CardDefaults.cardElevation(0.dp),
                                                        colors = CardDefaults.cardColors(
                                                            containerColor = Color.White
                                                        )
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .height(100.dp)
                                                                .fillMaxWidth(),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Image(
                                                                // painterResource(successInfo.successInfoImageId)
                                                                painterResource(R.drawable.fiction),
                                                                contentDescription = "",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier.fillMaxSize()
                                                            )

                                                            // will display in the middle of the image
                                                            Text(
                                                                "Fiction",
                                                                letterSpacing = TextUnit(
                                                                    0.3F,
                                                                    TextUnitType.Sp
                                                                ),
                                                                fontSize = 18.sp,
                                                                color = Color.White,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier
                                                                    .padding(top = 50.dp)
                                                                    .padding(10.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
//                                Spacer(modifier = Modifier.height(100.dp))

                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 170.dp,)
                                                .height(300.dp)
                                                .fillMaxWidth()
                                                .shadow(
                                                    elevation = 8.dp,
                                                    shape = RoundedCornerShape(20.dp)
                                                ),
                                            elevation = CardDefaults.cardElevation(0.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = Color.White
                                            )
                                        ) {
                                            Row {
                                                Text(
                                                    text = "Trending Books",
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    modifier = Modifier.padding(8.dp),
                                                    color = Color(0xFF9F2B68)
                                                )
                                            }

                                            LazyRow {
                                                item {
                                                    Row {
                                                        Card(
                                                            border = BorderStroke(3.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(103.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/226/9781250006226.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(3.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_4),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }

                                                        Card(
                                                            border = BorderStroke(3.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.book8),
                                                                contentDescription = "food",
                                                                modifier = Modifier
                                                                    .fillMaxSize()
                                                                    .padding(0.dp)
                                                            )
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_5),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://d2g9wbak88g7ch.cloudfront.net/productimages/images200/278/9780349434278.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/444/9781463800444.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/444/9781463800444.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }

                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/815/9781444775815.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_10),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_11),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_12),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_13),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            LazyRow {
                                                item {
                                                    Row {
                                                        Card(
                                                            border = BorderStroke(
                                                                2.dp,
                                                                Color(0xFF9F2B68)
                                                            ),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Image(
                                                                painter = painterResource(id = R.drawable.img_2),
                                                                contentDescription = "food",
                                                                modifier = Modifier
                                                                    .fillMaxSize()
                                                                    .padding(0.dp)
                                                            )
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_3),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {

                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_14),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(
                                                                2.dp,
                                                                Color(0xFF9F2B68)
                                                            ),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_14),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(
                                                                2.dp,
                                                                Color(0xFF9F2B68)
                                                            ),
                                                            modifier = Modifier
//                                                                .clickable {navController.navigate(
//                                                                    ROUTE_DETAILS)  }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/815/9781444775815.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(
                                                                2.dp,
                                                                Color(0xFF9F2B68)
                                                            ),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(5.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/906/9780143445906.jpg",
                                                                    contentDescription = "null",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/478/9789355991478.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )

                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://d2g9wbak88g7ch.cloudfront.net/productimages/images200/691/9781848690691.jpg",
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                Image(
                                                                    painter = painterResource(id = R.drawable.img_10),
                                                                    contentDescription = "food",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(5.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/258/9780385539258.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                )
                                                            }
                                                        }

                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/801/9780803736801.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/595/9780441569595.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                    }
                                                }
                                            }
                                        }
                                    }

                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 490.dp,)
                                                .height(300.dp)
                                                .fillMaxWidth()
                                                .shadow(
                                                    elevation = 8.dp,
                                                    shape = RoundedCornerShape(20.dp)
                                                ),
                                            elevation = CardDefaults.cardElevation(0.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = Color.White
                                            )
                                        ) {
                                            Row {
                                                Text(
                                                    text = "New Arrivals",
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    modifier = Modifier.padding(8.dp),
                                                    color = Color(0xFF9F2B68)
                                                )
                                            }


                                            LazyRow {
                                                item {
                                                    Row {
                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/455/9781897238455.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/776/9781250316776.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(
                                                                2.dp,
                                                                Color(0xFF9F2B68)
                                                            ),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(
//                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/990/9781567184990.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(5.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/029/9780312243029.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable{navController.navigate(ROUTE_DETAILS)}
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/208/9781449446208.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
                                                                .clickable { navController.navigate(
                                                                    ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/035/9780393089035.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://d2g9wbak88g7ch.cloudfront.net/productimages/images200/990/9781534430990.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/113/9780679889113.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/638/9780679890638.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/449/9780310221449.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/408/9780316118408.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/125/9780441478125.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }

                                                    }
                                                }
                                            }

                                            LazyRow {
                                                item {
                                                    Row {
                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/587/9780385730587.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/678/9780374607678.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/676/9781616205676.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(5.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/434/9780545522434.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://d2g9wbak88g7ch.cloudfront.net/productimages/images200/008/9781646140008.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(100.dp)
                                                                .width(104.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/999/9780545430999.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/006/9780674430006.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/421/9781582702421.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(12.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/525/9780375760525.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(12.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/974/9780590929974.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/558/9781250800558.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                        Card(
                                                            border = BorderStroke(2.dp, Color(0xFF9F2B68)),
                                                            modifier = Modifier
//                                                                .clickable { navController.navigate(ROUTE_DETAILS) }
                                                                .padding(10.dp)
                                                                .height(104.dp)
                                                                .width(100.dp)
                                                                .shadow(
                                                                    elevation = 8.dp,
                                                                    shape = RoundedCornerShape(13.dp)
                                                                ),
                                                            elevation = CardDefaults.cardElevation(0.dp),
                                                            colors = CardDefaults.cardColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Box {
                                                                AsyncImage(
                                                                    model = "https://www.bookswagon.com/productimages/images200/149/9781400043149.jpg",
                                                                    contentDescription = null,
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .padding(0.dp)
                                                                )
                                                            }
                                                        }


                                                    }
                                                }
                                            }
                                        }
                                    }



                                }
                            }



                        }
                    }

                }
            }

},
        bottomBar = {
            BottomNavigation(
                elevation = 10.dp,
                modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
                backgroundColor = Color(0xFF9F2B68)


            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Home, "", tint = Color.White)
                    },
                    label = { Text(text = "Home", color = Color.White ) },
                    selected = false,  // Modify based on your selected index logic
                    onClick = {
                        navController.navigate(ROUTE_LIBRARY)
                    }
                )

                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Default.Menu,
                            "",
                            tint = Color.White)
                    },
                    label = { Text(text = "Library", color = Color.White )},
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










