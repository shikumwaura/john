package com.example.mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.home.Home
import com.example.mvvm.ui.library.Library
import com.example.mvvm.ui.products.DetailsScreen
import com.example.mvvm.ui.products.InsertProductsScreen
import com.example.mvvm.ui.products.ViewProductsScreen


@Composable
fun AppNavHost(

    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
){

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(ROUTE_LIBRARY){ Library(navController) }

        composable(ROUTE_HOME){ Home(navController) }

        composable(ROUTE_INSERT) { InsertProductsScreen(navController) }

        composable(ROUTE_VIEW) { ViewProductsScreen(navController) }

//        composable(ROUTE_DETAILS){ DetailsScreen(String.toString()) }


        composable("details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            productId?.let {
                DetailsScreen(productId, navController)
            }
        }


























































    }
















}