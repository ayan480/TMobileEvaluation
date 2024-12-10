package com.syncoders.tmobileevaluation.ui.screens.profile.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper
import com.syncoders.domain.model.auth.User
import com.syncoders.domain.usecase.profile.ProfileUseCase
import com.syncoders.domain.utills.ResultState
import com.syncoders.domain.utills.ResultState.Failure
import com.syncoders.tmobileevaluation.ui.screens.profile.intent.ProfileIntent
import com.syncoders.tmobileevaluation.ui.screens.profile.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileUseCase: ProfileUseCase, private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModel() {
    private val _profileUiState = MutableStateFlow<ProfileState>(ProfileState.InitialState)
    val profileUiState: StateFlow<ProfileState> = _profileUiState.asStateFlow()

    val userName =  mutableStateOf("")


    init {
        getProfile()
    }

    private fun getProfile() {
        val user : User? = sharedPreferencesHelper.getUser()

        user?.let {
            userName.value = it.name
        }
    }

    fun logOut(){

    }


    fun onIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.ShowLogoutDialog -> {
                _profileUiState.value = ProfileState.LogoutDialog(isVisible = true)
            }
            is ProfileIntent.ConfirmLogout -> {
                viewModelScope.launch {
                    _profileUiState.value = ProfileState.Loading
                    var isLogout = profileUseCase.logout()
                    when (isLogout) {
                        is Failure -> {
                            _profileUiState.value = ProfileState.Error(message = "Logout failed")
                        }
                        is ResultState.Success ->{
                        _profileUiState.value = ProfileState.Success(message = "Logged out successfully")
                        }
                        else -> {


                        }
                    }
                }
            }
            is ProfileIntent.CancelLogout -> {
                _profileUiState.value = ProfileState.LogoutDialog(isVisible = false)
            }
            is ProfileIntent.NavigateToBookingHistory -> {
                _profileUiState.value = ProfileState.NavigatingToBookingHistoryList
            }
            is ProfileIntent.NavigateToPaymentHistory -> {
                _profileUiState.value = ProfileState.NavigatingToPaymentList
            }
            is ProfileIntent.NavigateToMyEvent -> {
                _profileUiState.value = ProfileState.NavigatingToMyEvent
            }

            is ProfileIntent.GetProfile -> {

            }
            else -> {

            }
        }
    }

    fun resetState(){
        _profileUiState.value = ProfileState.InitialState
    }



}