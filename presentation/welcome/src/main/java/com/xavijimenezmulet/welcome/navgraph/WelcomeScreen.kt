package com.xavijimenezmulet.welcome.navgraph

sealed class WelcomeScreen(val route: String) {
    object OnBoarding : WelcomeScreen(route = "onBoarding_screen")
}