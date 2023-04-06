package com.veramed.inven2.ui

sealed class Screen(val route:String) {
    object Principal:Screen(route = "pantalla_princial")
    object CargaDatos:Screen(route = "pantalla_cargadatos")


}