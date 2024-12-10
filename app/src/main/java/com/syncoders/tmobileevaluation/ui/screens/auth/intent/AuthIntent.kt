package com.syncoders.tmobileevaluation.ui.screens.auth.intent

sealed class AuthIntent {
    object NavigateToDashboard : AuthIntent()
    object NavigateToLogin : AuthIntent()
    object NavigateToRegister : AuthIntent()
    object Register : AuthIntent()
    object Login : AuthIntent()
}