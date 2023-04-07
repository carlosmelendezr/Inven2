package com.veramed.inven2.ui

sealed class Screen(val route:String) {
    object DatosIniciales:Screen(route = "pantalla_datos_iniciales")
    object CargaDatos:Screen(route = "pantalla_cargadatos")
    object Inicio:Screen(route = "pantalla_inicio")


}