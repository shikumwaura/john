package com.example.mvvm.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm.R
import com.example.mvvm.navigation.ROUTE_INSERT
import com.example.mvvm.navigation.ROUTE_LIBRARY
import com.example.mvvm.navigation.ROUTE_VIEW
import com.example.mvvm.navigation.ROUTE_DETAILS


@Composable
fun Home(navController: NavController) {


    Column {
        Box() {
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(1.dp)
                    .height(800.dp)
                    .background(color = Color(0xFF9F2B68), shape = RoundedCornerShape(35.dp))
                    .padding(6.dp)
                    .width(400.dp)

            ) {

                    Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 0.dp)
                ) {
                    Image(
                        // painterResource(successInfo.successInfoImageId)
                        painterResource(R.drawable.vvr2),
                        contentDescription = "",
//                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(500.dp)

                    )
                }

//                Row(verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .padding(top = 0.dp)
//
//                ){
//                    Text(
//                        "WELCOME TO BOOKY",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 30.sp,
//                        color = Color.White,
//                    )
//                }


            }
            Row {
                Card(
                    modifier = Modifier
                        .padding(1.dp)
                        .padding(top = 380.dp,)
                        .height(700.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(40.dp)
                        ),
                    elevation = CardDefaults.cardElevation(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp,)
                        .padding(0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                        Text(
                            "EXPLORE YOUR FAVORITE",
                            fontWeight = FontWeight.Light,
                            letterSpacing = TextUnit(1.5F, TextUnitType.Sp),
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
//                            fontSize = 30.sp,
                            color = Color(0xFF9F2B68),
                            modifier = Modifier
//                                .padding(40.dp)
//                                .padding(bottom = 100.dp)
                        )
                        Text(
                            " NOVEL",
                            fontWeight = FontWeight.Light,
                            letterSpacing = TextUnit(1.5F, TextUnitType.Sp),
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
//                            fontSize = 30.sp,
                            color = Color(0xFF9F2B68),
                        )

                        Spacer(Modifier.height(20.dp))

                        Text("Strengthen knowledge"
                            ,
                            style = MaterialTheme.typography.headlineSmall,
                            letterSpacing = TextUnit(0.3F, TextUnitType.Sp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF9F2B68),
                            modifier = Modifier
//                                .padding(bottom = 100.dp)
                                )

                        Text(" by reading Books"
                            ,
                            style = MaterialTheme.typography.headlineSmall,
                            letterSpacing = TextUnit(0.3F, TextUnitType.Sp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF9F2B68),
                            modifier = Modifier
//                                .padding(bottom = 100.dp)
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            onClick = { navController.navigate(ROUTE_LIBRARY) },
                            modifier = Modifier
                                .width(250.dp),

                            shape = RoundedCornerShape(10.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp,
                                pressedElevation = 6.dp

                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor =  Color(0xFF9F2B68),
                                contentColor = Color.White
                            ),
//                            border = BorderStroke( 2.dp, Color.White)


                        ) {

                            Text(
                                text = "Get Started",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                modifier = Modifier
//
                            )

                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                contentDescription = null,
//                                Modifier.size(30.dp)
                            )


                        }

//                        Text("INSERT",
//                            Modifier.clickable { navController.navigate(ROUTE_INSERT) }
//                        )
//
//                        Text("DETAILS",
//                            Modifier.clickable { navController.navigate(ROUTE_DETAILS) }
//                        )
//
//                        Text("VIEW",
//                            Modifier.clickable { navController.navigate(ROUTE_VIEW) }
//                        )


                    }

                }


            }

        }




    }

//
//                Column {
//
//
//                    Text(
//                        "Go to lib",
//                        color = Color.White,
//                        fontSize = 50.sp,
//                        modifier = Modifier
//                            .clickable { navController.navigate(ROUTE_LIBRARY) }
//
//                    )
//
//
//                    Text(
//                        "add book",
//                        color = Color.White,
//                        fontSize = 50.sp,
//                        modifier = Modifier
//                            .clickable { navController.navigate(ROUTE_INSERT) }
//
//                    )
//
//                    Text(
//                        "my books",
//                        color = Color.White,
//                        fontSize = 50.sp,
//                        modifier = Modifier
//                            .clickable { navController.navigate(ROUTE_MY_BOOKS) }
//
//                    )
//
//
//
//                    Text(
//                        "view books",
//                        color = Color.White,
//                        fontSize = 50.sp,
//                        modifier = Modifier
//                            .clickable { navController.navigate(ROUTE_VIEW) }
//
//                    )
//
//
//                }



        }



//@Composable
//fun Cardy(navController: NavController){
//
//    LazyColumn {
//        item {
//            Column {
//                Card(
//                    modifier = Modifier
//                        .padding(top = 180.dp,)
//                        .height(100.dp)
//                        .fillMaxWidth()
//                        .shadow(
//                            elevation = 8.dp,
//                            shape = RoundedCornerShape(20.dp)
//                        ),
//                    elevation = CardDefaults.cardElevation(0.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color.White
//                    )
//                ) {}
//        }
//    }
//
//
//
//
//    }

//}



