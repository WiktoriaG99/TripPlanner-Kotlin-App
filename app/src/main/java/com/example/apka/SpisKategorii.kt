package com.example.apka

class SpisKategorii {

    // Kategoria Zakwaterowanie
    var Zakwaterowanie: List<Kategoria> = mutableListOf<Kategoria>(

        Kategoria(
            "Hotel",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Kamping",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Znajomi",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        )
    )

    // Kategoria Przewozy
    var Przewozy: List<Kategoria> = mutableListOf<Kategoria>(
        Kategoria(
            "Samochód",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Samolot",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Komunikacja",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        )
    )

    // Kategoria Zajecia/Przedmioty
    var ZajeciaPrzedmioty: List<Kategoria> = mutableListOf<Kategoria>(
        Kategoria(
            "Niezbędne rzeczy",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        // Pamiętać o liczniku rzeczy!
        Kategoria(
            "Ubrania",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Kosmetyki",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Sporty Zimowe",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Plaża",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Festiwal",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Piesze wycieczki",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        )
    )

    // Kategoria Inne
    var Inne: List<Kategoria> = mutableListOf<Kategoria>(
        Kategoria(
            "Niemowlę",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        ),
        Kategoria(
            "Zwierzęta",
            mutableListOf<Przedmiot>(
                Przedmiot("Portfel", 1, false,false),
                Przedmiot("Ładowarka", 1, false, false),
                Przedmiot("Telefon", 1, false, false)
            )
        )
    )
}