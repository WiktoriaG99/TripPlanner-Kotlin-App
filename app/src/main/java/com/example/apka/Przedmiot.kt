package com.example.apka

import java.io.Serializable

class Przedmiot: Serializable {
    var ID: Int = 0
    var Kategoria: String = "Kategoria"
    var NazwaPrzedmiotu: String = "Nowy Przedmiot"
    var Liczba: Int = 1
    var CzyZalezneOdDlugosciPodrozy: Int = 0
    var CzyZaznaczony: Int = 0

    constructor()
    {
    }
    constructor(Kategoria: String, Nazwa: String, Liczba: Int, CzyZalezneOdDlugosciPodrozy: Int, CzyZaznaczony: Int)
    {
        this.Kategoria = Kategoria
        this.NazwaPrzedmiotu = Nazwa
        this.Liczba = Liczba
        this.CzyZalezneOdDlugosciPodrozy = CzyZalezneOdDlugosciPodrozy
        this.CzyZaznaczony = CzyZaznaczony
    }
}