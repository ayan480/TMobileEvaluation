package com.syncoders.tmobileevaluation.navigation

import ScreenContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syncoders.tmobileevaluation.ui.screens.homepage.view.HomeScreen
import com.syncoders.tmobileevaluation.ui.screens.profile.view.ProfileScreen
import com.syncoders.tmobileevaluation.ui.screens.travel.view.SearchScreen

@Composable
fun DashboardNavHost(
    parentNavController: NavHostController,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavTab.Home.route
    ) {
        composable(BottomNavTab.Home.route) {
            HomeScreen(parentNavController = parentNavController,
                dashboardNavController = navController)
        }
        composable(BottomNavTab.Search.route) {
            SearchScreen(parentNavController = parentNavController,
                dashboardNavController = navController)
        }
        composable(BottomNavTab.Notifications.route) {
            ScreenContent("Notifications")
        }
        composable(BottomNavTab.Profile.route) {
            ProfileScreen(
                parentNavController = parentNavController,
                dashboardNavController = navController
            )
        }
        composable(BottomNavTab.Menu.route) {
            ScreenContent("Menu")
        }
    }
}
