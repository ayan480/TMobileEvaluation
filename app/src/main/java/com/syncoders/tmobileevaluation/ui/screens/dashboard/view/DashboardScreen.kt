import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.R
import com.syncoders.tmobileevaluation.navigation.DashboardNavHost
import com.syncoders.tmobileevaluation.navigation.Destinations.HOME_TAB
import com.syncoders.tmobileevaluation.navigation.Destinations.MENU_TAB
import com.syncoders.tmobileevaluation.navigation.Destinations.NOTIFICATION_TAB
import com.syncoders.tmobileevaluation.navigation.Destinations.PROFILE_TAB
import com.syncoders.tmobileevaluation.navigation.Destinations.SEARCH_TAB
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorPrimary
import com.syncoders.tmobileevaluation.presentation.ui.theme.Grey
import com.syncoders.tmobileevaluation.presentation.ui.theme.White

@Composable
fun DashboardScreen(parentNavController: NavHostController,
                    dashboardNavController: NavHostController) {
    val dashboardNavController = rememberNavController()
    val currentBackStackEntry by dashboardNavController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val bottomNavItems = BottomNavTab.values().toList()

    Box(modifier = Modifier.fillMaxSize()) {
        // Nested Navigation Host
        DashboardNavHost(parentNavController = parentNavController, navController = dashboardNavController)

        // Bottom Navigation Bar
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = White // Change to your desired color
        ) {
            bottomNavItems.forEach { tab ->
                NavigationBarItem(
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (currentRoute != tab.route) {
                            dashboardNavController.navigate(tab.route) {
                                popUpTo(dashboardNavController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(id = tab.icon),
                            contentDescription = tab.title,
                            tint = if (currentRoute == tab.route) ColorPrimary else Grey
                        )
                    },
                   // label = { Text(text = tab.title, fontSize = 12.sp, color = Color.Black) }
                )
            }
        }
    }
}

@Composable
fun ScreenContent(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(parentNavController = rememberNavController(), dashboardNavController = rememberNavController())
}

enum class BottomNavTab(val route: String, val title: String, val icon: Int) {
    Home(HOME_TAB, "Home", R.drawable.ic_home),
    Search(SEARCH_TAB, "Search", R.drawable.baseline_location_on_24),
    Notifications(NOTIFICATION_TAB, "Notifications", R.drawable.ic_notification),
    Profile(PROFILE_TAB, "Profile", R.drawable.baseline_person_2_24),
    Menu(MENU_TAB, "menu", R.drawable.baseline_menu_24)
}