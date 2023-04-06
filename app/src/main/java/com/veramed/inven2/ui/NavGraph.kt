package com.veramed.inven2.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController ,
        startDestination = Screen.Principal.route
        ) {
        composable(
            route = Screen.Principal.route
        ) {
            pantalla_inicio(navController)
        }
        composable(
            route = Screen.CargaDatos.route
        ) {
            pantalla_datos()
        }
    }
    
}