package com.kev.nytimes.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object TopArticles : NavItem(
        title = "Top Articles",
        icon = Icons.Default.List,
        route = "top_articles_screen"
    )

    object SearchArticles : NavItem(
        title = "Search Articles",
        icon = Icons.Default.Search,
        route = "search_articles_screen"
    )
}
