package com.kev.nytimes.presentation.searcharticles

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kev.nytimes.R

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchArticlesScreen() {
    val viewModel = hiltViewModel<SearchArticlesViewModel>()
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {
            OutlinedTextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::searchArticles,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                label = {
                    Text(text = "Search here")
                },
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(12.dp))
            if (state.isLoading) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(R.raw.searching)
                    )

                    LottieAnimation(
                        modifier = Modifier.size(500.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )
                }
            }
            if (state.errorMessage.isNotEmpty()) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(R.raw.nointernet)
                    )

                    LottieAnimation(
                        modifier = Modifier.size(500.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )
                }
            }
            if (state.noResults) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(R.raw.noresultsfound)
                    )

                    LottieAnimation(
                        modifier = Modifier.size(500.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )


                }
            }
            if (state.data.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 72.dp)) {
                    items(state.data.size) { i ->
                        val article = state.data[i]
                        SearchArticlesItemComposable(result = article)
                    }
                }
            }
        }
    }
}
