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
        startDestination = Screen.Inicio.route
        ) {
        composable(
            route = Screen.Inicio.route
        ) {
            pantalla_inicio(navController)
        }
        composable(
            route = Screen.DatosIniciales.route
        ) {
            pantalla_datos_iniciales(navController)
        }
        composable(
            route = Screen.CargaDatos.route
        ) {
            pantalla_datos()
        }

    }
    
}