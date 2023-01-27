package com.fcenesiz.navigationcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fcenesiz.navigationcompose.presentation.DetailScreen
import com.fcenesiz.navigationcompose.presentation.MainScreen
import com.fcenesiz.navigationcompose.presentation.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Fatih"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(
                name = entry.arguments?.getString("name")
            )
        }
    }
}