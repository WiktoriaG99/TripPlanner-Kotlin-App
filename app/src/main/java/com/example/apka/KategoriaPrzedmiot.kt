package com.example.apka

class KategoriaPrzedmiot {
    var ID_Kategoria: Int = 0
    var ID_Przedmiot: Int = 0

    constructor()
    {
    }
    constructor(ID_Kategoria: Int, ID_Przedmiot: Int)
    {
        this.ID_Kategoria = ID_Kategoria
        this.ID_Przedmiot = ID_Przedmiot
    }

}