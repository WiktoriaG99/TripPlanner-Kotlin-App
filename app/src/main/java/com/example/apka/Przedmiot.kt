package com.example.apka

import java.io.Serializable

class Przedmiot: Serializable {
    // Unikalna nazwa - działa jak ID
    var NazwaPrzedmiotu: String = "Nowy Przedmiot"
    var Liczba: Int = 1
    var CzyZalezneOdDlugosciPodrozy: Boolean = false
    var CzyZaznaczony:Boolean = false

    constructor(Nazwa: String, Liczba: Int, CzyZalezneOdDlugosciPodrozy: Boolean, CzyZaznaczony: Boolean)
    {
        this.NazwaPrzedmiotu = Nazwa
        this.Liczba = Liczba
        this.CzyZalezneOdDlugosciPodrozy = CzyZalezneOdDlugosciPodrozy
        this.CzyZaznaczony = CzyZaznaczony
    }
}