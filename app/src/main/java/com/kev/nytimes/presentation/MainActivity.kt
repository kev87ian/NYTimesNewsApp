package com.kev.nytimes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.kev.nytimes.presentation.navigation.MainScreen
import com.kev.nytimes.ui.theme.NYTimesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYTimesTheme {
                // A surface container using the 'background' color from the theme
                val navHostController = rememberNavController()
                MainScreen(navHostController)
            }
        }
    }
}
