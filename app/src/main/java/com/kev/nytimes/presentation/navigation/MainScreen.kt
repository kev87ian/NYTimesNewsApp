package com.kev.nytimes.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kev.nytimes.presentation.mostviewedarticles.MostViewedArticlesScreen
import com.kev.nytimes.presentation.searcharticles.SearchArticlesScreen
import com.kev.nytimes.presentation.toparticles.TopArticlesScreen
import com.kev.nytimes.ui.theme.RobotoSemiBold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    val navItems = listOf(NavItem.TopArticles, NavItem.MostViewedArticles, NavItem.SearchArticles)
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.padding(top = 58.dp)
            ) {
                navItems.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == backStackEntry.value?.destination?.route,
                        onClick = { navController.navigate(item.route) },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "Bottom Icon")
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = RobotoSemiBold
                            )
                        },
                        alwaysShowLabel = false
                    )
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = NavItem.TopArticles.route) {
            composable(route = NavItem.TopArticles.route) {
                TopArticlesScreen(modifier = Modifier.padding(bottom = 48.dp))
            }
            composable(route = NavItem.MostViewedArticles.route) {
                MostViewedArticlesScreen()
            }
            composable(route = NavItem.SearchArticles.route) {
                SearchArticlesScreen()
            }
        }
    }
}
