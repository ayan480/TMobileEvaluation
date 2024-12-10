
package com.syncoders.tmobileevaluation.ui.screens.auth.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.navigation.Destinations.DASHBOARD_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.REGISTRATION_SCREEN
import com.syncoders.tmobileevaluation.navigation.Screens
import com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent


import com.syncoders.tmobileevaluation.ui.screens.auth.view.components.TransparentTextField
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorAssent
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.utils.UiUtils.showToast
import com.syncoders.tmobileevaluation.ui.dialog.LoaderDialog
import com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState
import com.syncoders.tmobileevaluation.ui.screens.auth.view.components.CarvedCornerCardForLogin
import com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel.LoginViewModel



@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel<LoginViewModel>()) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val email = viewModel.loginEmail.value
    val password = viewModel.loginPassword
    val emailError = viewModel.emailError.value
    val passwordError = viewModel.passwordError.value
    var passwordVisible by remember { mutableStateOf(false) }
    val viewState by viewModel.loginUiState.collectAsState()

    // Dialog visibility state
    var isDialogVisible by remember { mutableStateOf(false) }

    LaunchedEffect(viewState) {
        when (viewState) {
            is LoginState.Loading -> {
                isDialogVisible = true
            }
            is LoginState.Success -> {
                isDialogVisible = false
                val message = (viewState as LoginState.Success).message
                showToast(context = context, message = message)
                viewModel.resetLoginState()
                // Clear back stack and navigate to dashboard
                navController.navigate(DASHBOARD_SCREEN) {
                    popUpTo(Screens.Landing.route) { inclusive = true }
                }
                println("Success Message: $message")
                // Navigate to the next screen
            }
            is LoginState.Error -> {
                isDialogVisible = false
                // Show error message
                val errorMessage = (viewState as LoginState.Error).message
                println("Error Message: $errorMessage")
                showToast(context = context, message = errorMessage)
                // Handle error
            }
            is LoginState.NavigatingToRegister -> {
                println("Go to registration screen")
                navController.navigate(REGISTRATION_SCREEN)
            }
            else -> Unit
        }
    }

    // Show loader when the state is Loading
    if (isDialogVisible) {
        LoaderDialog(
            onDismissRequest = { isDialogVisible = false } // Close dialog when dismissed
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Screen UI components
        CarvedCornerCardForLogin()
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 36.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            TransparentTextField(
                value = email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = "Email",
                keyboardType = KeyboardType.Email,
                isError = emailError != null,
                errorMessage = emailError
            )
            /*if (emailError != null) {
                Text(
                    text = emailError,
                    color = Color.Red,
                    style = TextStyle(fontSize = 12.sp)
                )
            }*/

            Spacer(modifier = Modifier.height(16.dp))


            TransparentTextField(
                value = password.value,
                onValueChange = { viewModel.onPasswordChange(it) },
                label = "Password",
                keyboardType = KeyboardType.Password,
                isPasswordField = true,
                isError = passwordError != null,
                imeAction = ImeAction.Done,
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                errorMessage = passwordError
            )
            /*if (passwordError != null) {
                Text(
                    text = passwordError,
                    color = Color.Red,
                    style = TextStyle(fontSize = 12.sp)
                )
            }*/

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = viewModel.isRememberMe.value,
                    onCheckedChange = {
                        viewModel.rememberMeCheckChange(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Orange,
                        uncheckedColor = Color.Gray,
                        checkmarkColor = Color.White
                    )
                )
                Text(
                    text = "Remember Me",
                    style = MaterialTheme.typography.titleMedium,
                    color = Black,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }

            Text(
                text = "Forgot Password?",
                style = TextStyle(color = Black, textAlign = TextAlign.Center),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {
                    keyboardController?.hide()
//                    viewModel.onLoginClick()
                    viewModel.processLoginIntent(AuthIntent.Login)
                    },
                enabled = email.isNotEmpty() && password.value.isNotEmpty() && emailError == null && passwordError == null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W800),
                    modifier = Modifier.padding(horizontal = 36.dp, vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1.0F))
            ForgotPasswordText(
                fixedString = "Haven't an account?",
                clickableString = "Register"
            ) {
                println("Clickable text clicked!")
                viewModel.processLoginIntent(AuthIntent.NavigateToRegister)
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}





@Composable
fun ForgotPasswordText(
    fixedString: String = "Forgot password?",
    clickableString: String = "click_here",
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        // Add normal text
        append(fixedString)
        append(" ")

        // Add clickable text
        pushStringAnnotation(tag = "CLICK_HERE", annotation = clickableString)
        withStyle(
            style = SpanStyle(
                color = ColorAssent,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(clickableString)
        }
        pop()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = annotatedText,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "CLICK_HERE", start = offset, end = offset)
                    .firstOrNull()?.let {
                        println("Annotation found: ${it.item}") // Debugging log
                        onClick()
                    }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}

