package com.example.busschedule.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.busschedule.ui.screens.home.HomeScreen
import com.example.busschedule.ui.screens.stop.StopArrivalsScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationDestination.HomeNav.route,
        modifier = modifier,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        composable(route = NavigationDestination.HomeNav.route) {
            HomeScreen(navigateToDetailsScreen = {
                navController.navigate("${NavigationDestination.StopNav.route}/${it}")
            })
        }
        composable(
            route = NavigationDestination.StopNav.route + "/{${NavigationDestination.StopNav.stopNameArg}}",
            arguments = listOf(navArgument(NavigationDestination.StopNav.stopNameArg){
                type = NavType.StringType
            })
        ) {
            StopArrivalsScreen(
                navigateBack = {navController.navigateUp()},
            )
        }
    }
}