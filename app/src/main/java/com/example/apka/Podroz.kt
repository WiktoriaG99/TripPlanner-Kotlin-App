package com.example.apka

class Podroz {

    var ID: Int = 0
    var Nazwa: String = "Nowa podróż"
    var DataRozpoczecia: String = "01.01.2000"
    var DataZakonczenia: String = "31.01.2000"
    var Miejscowosc: String? = null
    var TypPodrozy: String = "Rekreacja" //i Biznes
    var ListaPrzedmiotow: MutableList<Przedmiot> = mutableListOf<Przedmiot>()


    constructor() {
    }
    constructor(Nazwa: String, DataRozpoczecia:String, DataZakonczenia:String, Miejscowosc:String, TypPodrozy:String
    )
    {
        this.Nazwa = Nazwa
        this.DataRozpoczecia = DataRozpoczecia
        this.DataZakonczenia = DataZakonczenia
        this.Miejscowosc = Miejscowosc
        this.TypPodrozy = TypPodrozy
    }
    constructor(
        Nazwa: String, DataRozpoczecia:String, DataZakonczenia:String, Miejscowosc:String, TypPodrozy:String,
        ListaPrzedmiotow: MutableList<Przedmiot>
    )
    {
        this.Nazwa = Nazwa
        this.DataRozpoczecia = DataRozpoczecia
        this.DataZakonczenia = DataZakonczenia
        this.Miejscowosc = Miejscowosc
        this.TypPodrozy = TypPodrozy
        this.ListaPrzedmiotow = ListaPrzedmiotow
    }
}
