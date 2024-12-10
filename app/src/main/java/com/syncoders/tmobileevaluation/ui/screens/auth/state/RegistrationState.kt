package com.syncoders.tmobileevaluation.ui.screens.auth.state

sealed class RegistrationState {
    object InitialState : RegistrationState()
    object Loading : RegistrationState()
    data class Success(val message:String): RegistrationState()
    data class Error(val message:String) : RegistrationState()



}