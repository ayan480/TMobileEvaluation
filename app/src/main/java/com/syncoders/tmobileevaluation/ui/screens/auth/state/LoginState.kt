package com.syncoders.tmobileevaluation.ui.screens.auth.state


sealed  class LoginState {
    object InitialState : LoginState()
    object Loading : LoginState()
    data class Success(val message:String): LoginState()
    data class Error(val message:String) : LoginState()


    object NavigatingToLogin : LoginState()
    object NavigatingToRegister : LoginState()
    object NavigatingToDashboard : LoginState()
}