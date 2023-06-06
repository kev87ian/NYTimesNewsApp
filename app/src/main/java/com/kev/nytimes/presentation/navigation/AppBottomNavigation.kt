package com.kev.nytimes.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val navItems = listOf(NavItem.TopArticles, NavItem.SearchArticles)

    BottomAppBar(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                          navController.navigate(it.route)
                },
                icon = { it.icon },
                label = { Text(text = it.title) },
                alwaysShowLabel = true
            )
        }
    }
}
