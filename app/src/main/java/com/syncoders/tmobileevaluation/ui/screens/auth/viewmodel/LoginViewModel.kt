package com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel


import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syncoders.core.utill.Validator.isValidEmail
import com.syncoders.core.utill.Validator.isValidPassword
import com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper
import com.syncoders.domain.usecase.auth.AuthUseCase
import com.syncoders.domain.utills.ResultState
import com.syncoders.domain.utills.ResultState.Failure
import com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent
import com.syncoders.tmobileevaluation.ui.screens.auth.state.LoginState
import com.syncoders.tmobileevaluation.ui.utils.ENTER_VALID_MAIL
import com.syncoders.tmobileevaluation.ui.utils.INVALID_PASSWORD_MSG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase, private val sharedPreferencesHelper: SharedPreferencesHelper
):ViewModel() {
    private val _landingViewState = MutableStateFlow<LoginState>(LoginState.InitialState)
    val landingViewState: StateFlow<LoginState> = _landingViewState.asStateFlow()

    private val _loginUiState = MutableStateFlow<LoginState>(LoginState.InitialState)
    val loginUiState: StateFlow<LoginState> = _loginUiState.asStateFlow()




    val loginEmail = mutableStateOf("")
    val loginPassword = mutableStateOf("")

    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val isRememberMe =  mutableStateOf<Boolean>(false)

    init {
        checkLogin()
        getSavedCredential()
    }

    private fun checkLogin() {
        println("LoggedIn --- ${sharedPreferencesHelper.getUserId()}")
        sharedPreferencesHelper.isLoggedIn().let {

            println("LoggedIn --- $it")
            if(it){
                processLandingIntent(AuthIntent.NavigateToDashboard)
            }else{
                getSavedCredential()
            }
        }

        }

    private fun getSavedCredential() {
        sharedPreferencesHelper.getLoginId()?.let {
            loginEmail.value = it
        }
        sharedPreferencesHelper.getLoginPassword()?.let {
            loginPassword.value = it
        }
        if(loginEmail.value.isNotEmpty() && loginPassword.value.isNotEmpty()){
            isRememberMe.value = true
        }else {
            isRememberMe.value = false
        }
    }

    fun onEmailChange(newEmail: String) {
        loginEmail.value = newEmail
        emailError.value = if (isValidEmail(newEmail)) null else ENTER_VALID_MAIL
    }
    fun onPasswordChange(newPassword: String) {
        loginPassword.value = newPassword
        passwordError.value = if (isValidPassword(newPassword)) null else INVALID_PASSWORD_MSG
    }

    private fun validateForm(): Boolean {
        val isEmailValid = isValidEmail(loginEmail.value).also { valid ->
            emailError.value = if (valid) null else ENTER_VALID_MAIL
        }
        val isPasswordValid = (isValidPassword(loginPassword.value)).also { valid ->
            passwordError.value = if (valid) null else INVALID_PASSWORD_MSG
        }
        return isEmailValid && isPasswordValid
    }

    fun onLoginClick() {
        if (validateForm()) {
            _loginUiState.value = LoginState.Loading

            // Use viewModelScope for coroutine, and Dispatchers.IO for network call
            viewModelScope.launch {
                // Use withContext to switch to IO dispatcher for the network call
                val response = withContext(Dispatchers.IO) {
                    authUseCase.login(emailId = loginEmail.value, password = loginPassword.value)
                }

                // Handle response in the main thread after network call is done
                when (response) {
                    is Failure -> {
                        _loginUiState.value = LoginState.Error(response.message ?: "Unknown error")
                    }

                    is ResultState.Success -> {
                        response.data?.let { data ->
                            if(isRememberMe.value){
                                println("password remember =====>>>> true")
                                sharedPreferencesHelper.saveLoginId(loginEmail.value)
                                sharedPreferencesHelper.saveLoginPassword(loginPassword.value)
                            }else {
                                println("password remember =====>>>> false")
                                sharedPreferencesHelper.saveLoginId("")
                                sharedPreferencesHelper.saveLoginPassword("")
                            }
                                sharedPreferencesHelper.saveUser(data)
                            _loginUiState.value = LoginState.Success(message = response.message?:"Success")
                        } ?: run {
                            _loginUiState.value = LoginState.Error("No data received")
                        }
                    }
                }
            }
        }
    }


    fun processLandingIntent(intent: AuthIntent) {
        when (intent) {
            is AuthIntent.NavigateToLogin -> {
                _landingViewState.value = LoginState.NavigatingToLogin
            }
            is AuthIntent.NavigateToRegister -> {
                _landingViewState.value = LoginState.NavigatingToRegister
            }
            is AuthIntent.NavigateToDashboard -> {
                _landingViewState.value = LoginState.NavigatingToDashboard
            }
            is AuthIntent.Login -> { onLoginClick() }

          else -> Unit
        }
    }

    fun processLoginIntent(intent: AuthIntent) {
        when (intent) {
            is AuthIntent.NavigateToLogin -> {
                _landingViewState.value = LoginState.NavigatingToLogin
            }
            is AuthIntent.NavigateToRegister -> {
                println("Go to registration screen.....")
                _landingViewState.value = LoginState.NavigatingToRegister
            }
            is AuthIntent.NavigateToDashboard -> {

                _landingViewState.value = LoginState.NavigatingToDashboard
            }
            is AuthIntent.Login -> { onLoginClick() }

          else -> Unit
        }
    }

fun rememberMeCheckChange(isCheck:Boolean){
    isRememberMe.value = isCheck
}

    // Reset the state to Idle after navigation
    fun resetLandingState() {
        _landingViewState.value = LoginState.InitialState
    }

    fun resetLoginState() {
        _loginUiState.value = LoginState.InitialState
    }
}