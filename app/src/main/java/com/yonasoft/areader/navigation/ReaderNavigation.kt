package com.yonasoft.areader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yonasoft.areader.screens.ReaderSplashScreen
import com.yonasoft.areader.screens.home.Home
import com.yonasoft.areader.screens.login.ReaderLoginScreen

@Composable
fun ReaderNavigation() {
    val navController =  rememberNavController()
    NavHost(navController = navController,
        startDestination = ReaderScreens.SplashScreen.name){

        composable(ReaderScreens.SplashScreen.name){
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name){
            ReaderLoginScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name){
            Home(navController = navController)
        }
    }
}