package com.syncoders.tmobileevaluation.navigation

import DashboardScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.ui.screens.auth.view.LandingScreen
import com.syncoders.tmobileevaluation.ui.screens.auth.view.LoginScreen
import com.syncoders.tmobileevaluation.presentation.auth.view.RegistrationScreen
import com.syncoders.tmobileevaluation.ui.screens.profile.view.BookingHistoryScreen
import com.syncoders.tmobileevaluation.ui.screens.profile.view.CalendarScreen
import com.syncoders.tmobileevaluation.ui.screens.profile.view.HistoryListScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Landing.route
    ) {
        composable(Screens.Landing.route) { LandingScreen(navController) }
        composable(Screens.Login.route) { LoginScreen(navController) }
        composable(Screens.Registration.route) { RegistrationScreen(navController) }
        composable(Screens.Dashboard.route) {
            val dashboardNavController = rememberNavController()
            DashboardScreen(
                parentNavController = navController,
                dashboardNavController = dashboardNavController
            )
        }

        composable(Screens.HistoryList.route) { HistoryListScreen(navController) }
        composable(Screens.BookingHistoryList.route) { BookingHistoryScreen(navController) }
        composable(Screens.MyEvent.route) { CalendarScreen(navController) }


    }
}

/*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.Landing.route
    ) {
        composable(
            route = Screens.Landing.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
        ) {
            LandingScreen(navController)
        }
        composable(
            route = Screens.Login.route,
            enterTransition = { fadeIn(animationSpec = tween(500)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screens.Registration.route,
            enterTransition = { slideInVertically(initialOffsetY = { it }) },
            exitTransition = { slideOutVertically(targetOffsetY = { -it }) }
        ) {
            RegistrationScreen(navController)
        }
    }
}
*/
