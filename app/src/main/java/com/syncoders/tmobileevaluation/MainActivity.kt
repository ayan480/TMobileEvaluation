package com.syncoders.tmobileevaluation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable

import androidx.navigation.compose.rememberNavController

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.syncoders.tmobileevaluation.ui.screens.auth.view.LandingScreen
import com.syncoders.tmobileevaluation.navigation.AppNavigation
import com.syncoders.tmobileevaluation.presentation.ui.theme.TMobileEvaluationTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TMobileEvaluationTheme {
                MyApp()

            }
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()

    AppNavigation(navController)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TMobileEvaluationTheme {
        val navController: NavHostController = rememberNavController()
        LandingScreen(navController)
    }
}