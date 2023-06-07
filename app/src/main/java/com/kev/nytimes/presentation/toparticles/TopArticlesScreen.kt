package com.kev.nytimes.presentation.toparticles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kev.nytimes.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopArticlesScreen() {
    val viewModel = hiltViewModel<TopArticlesViewModel>()
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        viewModel.getTopArticles()
    }
    if (state.isLoading) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(R.raw.loading)
            )

            LottieAnimation(
                modifier = Modifier.size(500.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever
            )
        }
    }
    if (state.errorMessage.isNotEmpty()) {
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.nointernet)
        )

        LottieAnimation(
            modifier = Modifier.size(500.dp),
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
    }
    if (state.data.isNotEmpty()) {
        LazyColumn(modifier = Modifier.padding(bottom = 72.dp).fillMaxSize().fillMaxHeight()) {
            items(state.data.size) { i ->
                val newsItem = state.data[i]

                TopArticlesItemComposable(result = newsItem)
            }
        }
    }
}

@Composable
fun LottieLoadingAnimation() {
}
