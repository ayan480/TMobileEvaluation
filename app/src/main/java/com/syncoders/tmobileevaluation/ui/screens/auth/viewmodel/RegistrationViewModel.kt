package com.syncoders.tmobileevaluation.ui.screens.auth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syncoders.core.utill.Validator
import com.syncoders.core.utill.Validator.isValidEmail
import com.syncoders.core.utill.Validator.isValidPhone
import com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper
import com.syncoders.domain.usecase.auth.AuthUseCase
import com.syncoders.domain.utills.ResultState
import com.syncoders.domain.utills.ResultState.Failure
import com.syncoders.tmobileevaluation.ui.screens.auth.state.RegistrationState
import com.syncoders.tmobileevaluation.ui.utils.AGREE_TERM_AND_CONDITION_MSG
import com.syncoders.tmobileevaluation.ui.utils.ENTER_FULL_NAME
import com.syncoders.tmobileevaluation.ui.utils.ENTER_VALID_MAIL
import com.syncoders.tmobileevaluation.ui.utils.ENTER_VALID_PHONE
import com.syncoders.tmobileevaluation.ui.utils.INVALID_CONFIRM_PASSWORD_MSG
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
class RegistrationViewModel @Inject constructor(private val authUseCase: AuthUseCase, private val sharedPreferencesHelper: SharedPreferencesHelper):ViewModel(){

    private val _registrationViewState = MutableStateFlow<RegistrationState>(RegistrationState.InitialState)
    val registrationViewState: StateFlow<RegistrationState> = _registrationViewState.asStateFlow()



    val name = mutableStateOf("")
    val mobileNo = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")

    val emailError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val confirmPasswordError = mutableStateOf<String?>(null)
    val nameError = mutableStateOf<String?>(null)
    val mobileNoError = mutableStateOf<String?>(null)

    val agreeTNC =  mutableStateOf<Boolean>(false)
    fun onNameChange(newEmail: String) {
        name.value = newEmail
        nameError.value = if (name.value.isEmpty())  ENTER_FULL_NAME else null
    }
    fun onEmailChange(newEmail: String) {
        email.value = newEmail
        emailError.value = if (isValidEmail(newEmail)) null else ENTER_VALID_MAIL
    }

    fun onPhoneNoChange(newPhone: String) {
        mobileNo.value = newPhone
        mobileNoError.value = if (isValidPhone(newPhone)) null else ENTER_VALID_PHONE
    }
    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
        passwordError.value = if (Validator.isValidPassword(newPassword)) null else INVALID_PASSWORD_MSG
    }
    fun onConfirmPasswordChange(confPassword: String) {
        confirmPassword.value = confPassword
        confirmPasswordError.value = if (password.value == confPassword) null else INVALID_CONFIRM_PASSWORD_MSG
    }
    fun validateForm(): Boolean {
        val isNameValid = (name.value.isNotEmpty()).also { valid ->
            nameError.value = if (valid) null else ENTER_FULL_NAME
        }
        val isEmailValid = isValidEmail(email.value).also { valid ->
            emailError.value = if (valid) null else ENTER_VALID_MAIL
        }
        val isMobileValid = isValidPhone(mobileNo.value).also { valid ->
            mobileNoError.value = if (valid) null else ENTER_VALID_PHONE
        }
        val isPasswordValid = Validator.isValidPassword(password.value).also { valid ->
            passwordError.value = if (valid) null else INVALID_PASSWORD_MSG
        }
        val isConfirmPasswordValid = (confirmPassword != password).also { invalid ->
            emailError.value = if (invalid) null else ENTER_VALID_MAIL
        }


        // Check if the terms and conditions checkbox is not checked
        val isAgreeTNCValid = agreeTNC.value

        if (isNameValid && isEmailValid && isMobileValid && isPasswordValid && isConfirmPasswordValid) {
            if (!isAgreeTNCValid) {
                viewModelScope.launch {
                    _registrationViewState.value = RegistrationState.Error(message = AGREE_TERM_AND_CONDITION_MSG);
                }
                return false // Return false as the form is not valid due to the unchecked T&C
            }
        }

        return isNameValid && isEmailValid && isMobileValid && isPasswordValid && isConfirmPasswordValid && isAgreeTNCValid
    }
    fun onSignupClick() {
        if (validateForm()) {
            // Use viewModelScope for coroutine, and Dispatchers.IO for network call
            viewModelScope.launch {
                // Use withContext to switch to IO dispatcher for the network call
                val response = withContext(Dispatchers.IO) {
                    authUseCase.signUp(emailId = email.value, name = name.value, phone = mobileNo.value, password = password.value)
                }

                // Handle response in the main thread after network call is done
                when (response) {
                    is Failure -> {
                        _registrationViewState.value = RegistrationState.Error(response.message ?: "Unknown error")
                    }

                    is ResultState.Success -> {
                        response.data?.let { data ->
                            _registrationViewState.value = RegistrationState.Success(message = response.message?:"Success")
                        } ?: run {
                            _registrationViewState.value = RegistrationState.Error("No data received")
                        }
                    }
                }
            }
        }
    }
    fun resetViewState(){
        name.value =""
        mobileNo.value =""
        email.value =""
        password.value =""
        confirmPassword.value =""

        emailError.value =""
        passwordError.value =""
        confirmPasswordError.value =""
        nameError.value =""
        mobileNoError.value =""

        _registrationViewState.value = RegistrationState.InitialState
    }
}