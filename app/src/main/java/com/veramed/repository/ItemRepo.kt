package com.veramed.repository

import com.veramed.model.Articulo

class ItemRepo {
    fun getTestData() : List<Articulo> {
        return listOf(
            Articulo(1,"7592456522","2050001","ARTICULO 001",2),
            Articulo(2,"7592456523","2050002","ARTICULO 002",4),
            Articulo(3,"7592456524","2050003","ARTICULO 003",6),
            Articulo(4,"7592456525","2050004","ARTICULO 004",8),
            Articulo(5,"7592456522","2050005","ARTICULO 005",2),
            Articulo(6,"7592544523","2050006","ARTICULO 006",3),
            Articulo(7,"7592456524","2050007","ARTICULO 007",6),
            Articulo(8,"7592456225","2050008","ARTICULO 008",9),
            Articulo(9,"7592456622","2050009","ARTICULO 009",95),
            Articulo(10,"7592456783","2050010","ARTICULO 010",1),
            Articulo(11,"7592456764","2050011","ARTICULO 011",3),
            Articulo(12,"7592456345","2050012","ARTICULO 012",4),
            Articulo(1,"7592456522","2050001","ARTICULO 001",2),
            Articulo(2,"7592456523","2050002","ARTICULO 002",4),
            Articulo(3,"7592456524","2050003","ARTICULO 003",6),
            Articulo(4,"7592456525","2050004","ARTICULO 004",8),
            Articulo(5,"7592456522","2050005","ARTICULO 005",2),
            Articulo(6,"7592544523","2050006","ARTICULO 006",3),
            Articulo(7,"7592456524","2050007","ARTICULO 007",6),
            Articulo(8,"7592456225","2050008","ARTICULO 008",9),
            Articulo(9,"7592456622","2050009","ARTICULO 009",95),
            Articulo(10,"7592456783","2050010","ARTICULO 010",1),
            Articulo(11,"7592456764","2050011","ARTICULO 011",3),
            Articulo(12,"7592456345","2050012","ARTICULO 012",4),
        )
    }
}