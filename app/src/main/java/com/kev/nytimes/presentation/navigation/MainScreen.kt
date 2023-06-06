package com.kev.nytimes.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController = navController)
        }
    ){
        NavHost(navController = navController, startDestination = NavItem.TopArticles.route) {
            composable(route = NavItem.TopArticles.route){

            }
            composable(route = NavItem.SearchArticles.route){

            }
        }
    }


}
