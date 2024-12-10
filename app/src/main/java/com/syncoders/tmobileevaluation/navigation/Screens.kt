package com.syncoders.tmobileevaluation.navigation

import com.syncoders.tmobileevaluation.navigation.Destinations.BOOKING_HISTORY_LIST_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.DASHBOARD_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.HISTORY_LIST_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.LANDING_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.LOGIN_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.MY_EVENT_SCREEN
import com.syncoders.tmobileevaluation.navigation.Destinations.REGISTRATION_SCREEN

sealed class Screens(val route:String) {
    object Landing : Screens(LANDING_SCREEN)
    object Login : Screens(LOGIN_SCREEN)
    object Registration : Screens(REGISTRATION_SCREEN)
    object Dashboard : Screens(DASHBOARD_SCREEN)

    object HistoryList : Screens(HISTORY_LIST_SCREEN)
    object BookingHistoryList : Screens(BOOKING_HISTORY_LIST_SCREEN)
    object MyEvent : Screens(MY_EVENT_SCREEN)

}