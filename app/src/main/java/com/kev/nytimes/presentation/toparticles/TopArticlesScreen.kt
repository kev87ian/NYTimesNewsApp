package com.kev.nytimes.presentation.toparticles

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TopArticlesScreen(
modifier: Modifier
) {
    val viewModel = hiltViewModel<TopArticlesViewModel>()
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        viewModel.getTopArticles()
    }
    if (state.isLoading) {
        CircularProgressIndicator()
    }
    if (state.errorMessage.isNotEmpty()) {
        Text(text = state.errorMessage)
    }
    if (state.data.isNotEmpty()) {
        LazyColumn(modifier = Modifier.padding(bottom = 100.dp).fillMaxSize().fillMaxHeight()) {
            items(state.data.size) { i ->
                val newsItem = state.data[i]

                TopArticlesItemComposable(result = newsItem)
            }
        }

    }
}
