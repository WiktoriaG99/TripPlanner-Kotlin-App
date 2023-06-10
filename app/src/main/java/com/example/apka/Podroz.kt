package com.example.apka

class Podroz {

    var ID: Int = 0
    var Nazwa: String = "Nowa podróż"
    var DataRozpoczecia: String = "01.01.2000"
    var DataZakonczenia: String = "31.01.2000"
    var Miejscowosc: String? = null
    var TypPodrozy: String = "Rekreacja" //i Biznes
    var ListaPrzedmiotow: MutableCollection<Przedmiot> = mutableListOf<Przedmiot>()


    constructor(
        ID: Int, Nazwa: String, DataRozpoczecia:String, DataZakonczenia:String, Miejscowosc:String, TypPodrozy:String,
        ListaPrzedmiotow: MutableCollection<Przedmiot>
    )
    {
        this.ID = ID
        this.Nazwa = Nazwa
        this.DataRozpoczecia = DataRozpoczecia
        this.DataZakonczenia = DataZakonczenia
        this.Miejscowosc = Miejscowosc
        this.TypPodrozy = TypPodrozy
        this.ListaPrzedmiotow = ListaPrzedmiotow
    }

}
