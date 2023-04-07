package com.veramed.model

import java.util.*

data class ItemLista(
    val id:Int,
    val timestamp:Long,
    val nombre:String,
    val descripcion:String,
    val color: Int,
    val fecha: Calendar,
    val tienda: Int
    ) {

}