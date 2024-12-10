package com.syncoders.tmobileevaluation.ui.screens.profile.view


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.R
import com.syncoders.tmobileevaluation.navigation.Destinations.BOOKING_HISTORY_LIST_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.HISTORY_LIST_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.LANDING_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.MY_EVENT_SCREEN
import com.syncoders.tmobileevaluation.navigation.Screens
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.Grey
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.common_components.CurveHeader
import com.syncoders.tmobileevaluation.ui.dialog.LogoutConfirmationDialog
import com.syncoders.tmobileevaluation.ui.screens.profile.intent.ProfileIntent
import com.syncoders.tmobileevaluation.ui.screens.profile.state.ProfileState
import com.syncoders.tmobileevaluation.ui.screens.profile.viewmodel.ProfileViewModel
import com.syncoders.tmobileevaluation.ui.utils.UiUtils.showToast


@Composable
fun ProfileScreen(parentNavController: NavHostController,
                  dashboardNavController: NavHostController, viewModel : ProfileViewModel = hiltViewModel<ProfileViewModel>()) {
    val viewState by viewModel.profileUiState.collectAsState()
    val context = LocalContext.current // Get the current context
    val keyboardController = LocalSoftwareKeyboardController.current // Controller to manage keyboard
    // Dialog visibility state
    var isDialogVisible by remember { mutableStateOf(false) }


    when (viewState) {
        is ProfileState.InitialState -> {
            // Display the initial profile screen content
            isDialogVisible = false
        }
        is ProfileState.Loading -> {
            // Show a loading indicator
            isDialogVisible = true
        }
        is ProfileState.Success -> {
            isDialogVisible = false
            val message = (viewState as ProfileState.Success).message
            showToast(context = context, message = message)
            viewModel.resetState()
            parentNavController.navigate(LANDING_SCREEN) {
                popUpTo(Screens.Dashboard.route) { inclusive = true }
            }
            // Show a success message or navigate to another screen
        }
        is ProfileState.Error -> {
            isDialogVisible = false
            val message = (viewState as ProfileState.Error).message
            showToast(context = context, message = message)
        }
        is ProfileState.LogoutDialog -> {
            isDialogVisible = false
            val isVisible = (viewState as ProfileState.LogoutDialog).isVisible
            if (isVisible) {
                LogoutConfirmationDialog(
                    showDialog = isVisible,
                    onConfirm = { viewModel.onIntent(ProfileIntent.ConfirmLogout) },
                    onCancel = { viewModel.onIntent(ProfileIntent.CancelLogout) }
                )
            }
        }

        ProfileState.NavigatingToBookingHistoryList -> {
            parentNavController.navigate(BOOKING_HISTORY_LIST_SCREEN)
            viewModel.resetState()
        }

        ProfileState.NavigatingToPaymentList -> {
            parentNavController.navigate(HISTORY_LIST_SCREEN)
            viewModel.resetState()
        }

        ProfileState.NavigatingToMyEvent -> {
            parentNavController.navigate(MY_EVENT_SCREEN)
            viewModel.resetState()
        }
    }


    Scaffold(
        topBar = {
            CurveHeader("My Profile")
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Profile Header
                Icon(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24), // Replace with the actual drawable
                    contentDescription = "Profile Picture",
                    tint = Color.White,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(Orange)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = viewModel.userName.value,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Black
                    ),
                )

Spacer(modifier = Modifier.height(16.dp))
                // Options List
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .border(
                            border = BorderStroke(
                                width = 3.dp,
                                color = Color(0xFFD9D9D9) // Replace with your desired color
                            ),
                            shape = MaterialTheme.shapes.medium // Optional: Adjust the shape of the border
                        ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardColors(containerColor = Color.White, contentColor = Color.White, disabledContentColor = Color.White, disabledContainerColor = Color.White)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp, vertical = 16.dp),
                        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(profileOptions) { option ->
                            ProfileOptionRow(option, viewModel)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ProfileOptionRow(option: ProfileOption, viewModel: ProfileViewModel) {
    // State to manage background color during click
    var isClicked by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(
        targetValue = if (isClicked) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) else Color.Transparent
    )

    // Side effect to reset click state after animation
    if (isClicked) {
        LaunchedEffect(isClicked) {
            kotlinx.coroutines.delay(300) // Delay for animation
            isClicked = false
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = if (option.label == "Log out") 48.dp else 0.dp)
            .background(backgroundColor) // Apply background color animation
            .clickable {
                isClicked = true // Trigger animation
                // Handle click actions
                if (option.label == "Log out") {
                    viewModel.onIntent(ProfileIntent.ShowLogoutDialog)
                } else if (option.label == "Booking History") {
                    viewModel.onIntent(ProfileIntent.NavigateToBookingHistory)
                } else if (option.label == "Payment History") {
                    viewModel.onIntent(ProfileIntent.NavigateToPaymentHistory)
                }
                else if (option.label == "My Event") {
                    viewModel.onIntent(ProfileIntent.NavigateToMyEvent)
                } else {
                    option.onClick()
                }
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = option.label,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Black
            ),
            modifier = Modifier.weight(1f),
        )
        Icon(
            imageVector = if (option.label == "Log out") Icons.Default.Logout else Icons.Default.ArrowForward,
            contentDescription = "Arrow",
            tint = if (option.label == "Log out") Grey else Orange
        )
    }
}

// Sample Data
data class ProfileOption(val label: String, val onClick: () -> Unit)

val profileOptions = listOf(
    ProfileOption("Edit Profile") {},
    ProfileOption("Change Password") {},
    ProfileOption("My Event") {},
    ProfileOption("Booking History") {},
    ProfileOption("Payment History") {},
    ProfileOption("Help") {},
    ProfileOption("Log out") {}
)










@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(parentNavController = rememberNavController(), dashboardNavController = rememberNavController())
}






