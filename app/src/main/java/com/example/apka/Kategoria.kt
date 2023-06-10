package com.example.apka

class Kategoria {
    var Nazwa: String = "Nowa kategoria"
    var ListaPrzedmiotow: MutableCollection<Przedmiot> = mutableListOf<Przedmiot>()

    constructor(Nazwa: String, ListaPrzedmiotow: MutableCollection<Przedmiot>)
    {
        this.Nazwa = Nazwa
        this.ListaPrzedmiotow = ListaPrzedmiotow
    }

}
