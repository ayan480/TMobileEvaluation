package com.syncoders.tmobileevaluation.ui.screens.profile.intent

sealed class ProfileIntent {
    object GetProfile : ProfileIntent()
    object ShowLogoutDialog : ProfileIntent()
    object ConfirmLogout : ProfileIntent()
    object CancelLogout : ProfileIntent()
    object NavigateToBookingHistory : ProfileIntent()
    object NavigateToPaymentHistory : ProfileIntent()
    object NavigateToMyEvent : ProfileIntent()
}