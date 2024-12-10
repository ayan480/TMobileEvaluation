package com.syncoders.tmobileevaluation.presentation.auth.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.navigation.Destinations.LOGIN_SCREEN
import com.syncoders.tmobileevaluation.navigation.Screens

import com.syncoders.tmobileevaluation.ui.screens.auth.view.components.TransparentTextField
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.dialog.LoaderDialog
import com.syncoders.tmobileevaluation.ui.screens.auth.state.RegistrationState
import com.syncoders.tmobileevaluation.ui.screens.auth.view.components.CarvedCornerCardForSignup
import com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel.RegistrationViewModel
import com.syncoders.tmobileevaluation.ui.utils.UiUtils.showToast


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController, viewModel: RegistrationViewModel = hiltViewModel<RegistrationViewModel>()) {


    val name = viewModel.name.value
    val mobileNo = viewModel.mobileNo.value
    val email = viewModel.email.value
    val password = viewModel.password.value
    val confirmPassword = viewModel.confirmPassword.value
    val emailError = viewModel.emailError.value
    val passwordError = viewModel.passwordError.value
    val mobileNoError = viewModel.mobileNoError.value
    val nameError = viewModel.nameError.value
    val confirmPasswordError = viewModel.confirmPasswordError.value

    var passwordVisible by remember { mutableStateOf(false) } // State for password visibility
    var confirmPasswordVisible by remember { mutableStateOf(false) } // State for password visibility


    // State for the bottom sheet visibility
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val viewState by viewModel.registrationViewState.collectAsState()

    // Dialog visibility state
    var isDialogVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current


    LaunchedEffect(viewState) {
        when (viewState) {
            is RegistrationState.Loading -> {
                isDialogVisible = true
            }
            is RegistrationState.Success -> {
                isDialogVisible = false
                val message = (viewState as RegistrationState.Success).message
                showToast(context = context, message = message)
                println("Success Message: $message")
                viewModel.resetViewState()
                navController.navigate(LOGIN_SCREEN) {
                    popUpTo(Screens.Login.route) { inclusive = true }
                }


            }
            is RegistrationState.Error -> {
                isDialogVisible = false
                // Show error message
                val errorMessage = (viewState as RegistrationState.Error).message
                println("Error Message: $errorMessage")
                showToast(context = context, message = errorMessage)
                // Handle error
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
    Column {
        // Top carved card for the profile image
        CarvedCornerCardForSignup(coroutineScope, bottomSheetScaffoldState)
        Spacer(modifier = Modifier.height(8.dp))

        // Registration form
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 36.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Full Name TextField
            TransparentTextField(
                value = name,
                onValueChange = { viewModel.onNameChange(it) },
                label = "Full Name",
                keyboardType = KeyboardType.Text,
                errorMessage = nameError
            )

            // Email TextField
            TransparentTextField(
                value = email,
                onValueChange = {  viewModel.onEmailChange(it)  },
                label = "Email",
                keyboardType = KeyboardType.Email,
                errorMessage = emailError
            )

            // Mobile No TextField
            TransparentTextField(
                value = mobileNo,
                onValueChange = {  viewModel.onPhoneNoChange(it)  },
                label = "Mobile No",
                keyboardType = KeyboardType.Phone,
                errorMessage = mobileNoError
            )


            // New Password TextField
            TransparentTextField(
                value = password,
                onValueChange = {  viewModel.onPasswordChange(it)  },
                label = "New Password",
                keyboardType = if (passwordVisible) KeyboardType.Text else KeyboardType.Password,
                isPasswordField = true,
                imeAction = ImeAction.Next,
                trailingIcon = {
                    androidx.compose.material3.IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        androidx.compose.material3.Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                errorMessage = passwordError
            )

            // Confirm Password TextField
            TransparentTextField(
                value = confirmPassword,
                onValueChange = {  viewModel.onConfirmPasswordChange(it)  },
                label = "Confirm Password",
                keyboardType = if (confirmPasswordVisible) KeyboardType.Text else KeyboardType.Password,
                isPasswordField = true,
                trailingIcon = {
                    androidx.compose.material3.IconButton(onClick = {
                        confirmPasswordVisible = !confirmPasswordVisible
                    }) {
                        androidx.compose.material3.Icon(
                            imageVector = if (confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (confirmPasswordVisible) "Hide Password" else "Show Password"
                        )
                    }
                },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                imeAction = ImeAction.Done,
                errorMessage = confirmPasswordError
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Terms and Conditions Checkbox
            TNCCheckbox(viewModel.agreeTNC)

            // Signup Button
            Button(
                onClick = { viewModel.onSignupClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "Signup",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W800),
                    modifier = Modifier.padding(horizontal = 36.dp, vertical = 8.dp)
                )
            }
            // Camera selection bottom sheet
          //  CameraSelectionBottomSheet(bottomSheetScaffoldState, coroutineScope)

        }
    }
}



@Composable
fun TNCCheckbox(agreeTNC: MutableState<Boolean>) {
    var isChecked by remember { agreeTNC }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Orange,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "I agree the terms and condition",
            style = MaterialTheme.typography.body1,
            color =  Black
        )
    }
}





@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(navController = rememberNavController())
}
