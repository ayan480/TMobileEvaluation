package com.syncoders.tmobileevaluation.ui.screens.profile.state



sealed  class ProfileState {
    object InitialState : ProfileState()
    object Loading : ProfileState()
    data class Success(val message: String) : ProfileState()
    data class Error(val message: String) : ProfileState()
    data class LogoutDialog(val isVisible: Boolean = false) : ProfileState()

    object NavigatingToBookingHistoryList : ProfileState()
    object NavigatingToPaymentList : ProfileState()
    object NavigatingToMyEvent : ProfileState()

}