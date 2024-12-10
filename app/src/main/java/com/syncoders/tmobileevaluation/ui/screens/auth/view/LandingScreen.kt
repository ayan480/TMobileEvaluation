package com.syncoders.tmobileevaluation.ui.screens.auth.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syncoders.tmobileevaluation.R
import com.syncoders.tmobileevaluation.navigation.Destinations.DASHBOARD_SCREEN

import com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent
import com.syncoders.tmobileevaluation.navigation.Destinations.LOGIN_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.REGISTRATION_SCREEN
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorAssent
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorPrimary
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorPrimaryDark
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState
import com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel.LoginViewModel


@Composable
fun LandingScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel<LoginViewModel>(),
) {
    // Remember System UI Controller
    val systemUiController = rememberSystemUiController()
    val statusBarColor = ColorPrimaryDark // Set your desired status bar color

    val viewState by viewModel.landingViewState.collectAsState()

    // Observe and react to viewState changes
    LaunchedEffect(viewState) {
        when (viewState) {
            is LoginState.NavigatingToLogin -> {
                navController.navigate(LOGIN_SCREEN)
                viewModel.resetLandingState()
            }

            is LoginState.NavigatingToRegister -> {
                navController.navigate(REGISTRATION_SCREEN)
                viewModel.resetLandingState()
            }
            is LoginState.NavigatingToDashboard -> {
                navController.popBackStack()
                navController.navigate(DASHBOARD_SCREEN)
                viewModel.resetLandingState()
            }

            else -> Unit
        }
    }


    // Set the Status Bar Color
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false // Set to true if you want dark icons for light status bar colors
        )
    }
    Surface {
        VerticalGradient(
            modifier = Modifier,
            // Change Colors, you can add TWO or more Colors
            listColors = listOf(ColorPrimaryDark, ColorPrimary,ColorAssent)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderTitle(
                    modifier = Modifier.padding(top = 24.dp)
                )
                Spacer(Modifier.height(48.dp))
                HeaderImage()
                Spacer(Modifier.height(48.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),

                    colors = ButtonColors(
                        containerColor = Orange,
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.LightGray
                    ),
                    onClick = {
                        viewModel.processLandingIntent(AuthIntent.NavigateToLogin)
                    }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 36.dp, vertical = 8.dp),
                        text = "Login",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(Modifier.height(24.dp))
                OutlinedButton(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White // Set text color to white
                    ),
                    border = BorderStroke(1.dp, Color.White),
                    onClick = {
                        viewModel.processLandingIntent(AuthIntent.NavigateToRegister)
                    }) {
                    Text(
                        modifier = Modifier.padding(horizontal = 36.dp, vertical = 8.dp),
                        text = "Register",
                        color = Color.White,

                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Log in with ", style = TextStyle(
                            color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.W700
                        )
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(60.dp)
                        )

                    }
                    Spacer(Modifier.width(24.dp))
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(60.dp)
                        )

                    }
                }
            }
        }


    }
}

@Composable
fun HeaderImage() {
    // Image(painter = )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 40.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Circular Image Card
        Card(
            modifier = Modifier.size(210.dp),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(2.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.globe_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun VerticalGradient(
    modifier: Modifier,
    listColors: List<Color>,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listColors
                )
            ),
        content = content
    )
}

@Composable
fun HeaderTitle(modifier: Modifier = Modifier) {
    Text(
        text = "DELIVERY APP",
        modifier = modifier,
        color = Color.White,
        fontSize = 26.sp,
        style = TextStyle(fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace)

    )
}


@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(navController = rememberNavController()) // Mock NavController
}