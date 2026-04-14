package com.example.busschedule.ui.navigation

sealed interface NavigationDestination {
    object HomeNav {
        const val route: String = "HOME"
    }
    object StopNav {
        const val route: String = "STOP"
        const val stopNameArg: String = "stopName"
    }
}
