package com.veramed.repository

import com.veramed.model.Articulo
import com.veramed.model.ItemLista
import java.util.*

class ListaRepo {

    fun getTestData() : List<ItemLista> {
        return listOf(
            ItemLista(1,26565265, "JOSE PEREZ","TOMA FISICA CONSIGNACION",0, Calendar.getInstance(),1 ))}
}