package com.example.apka

class DaneAplikacji {

    //Lista list - Podróże, zawierające pojedyncze elementy Podroz
    public var Podroze = mutableListOf<Podroz>(
        Podroz(0, "Wakacje", "01-06-2023", "07-06-2023",
        "Katowice", "Rekreacja",
            mutableListOf<Przedmiot>(
                Przedmiot("Szampon", 1, false, false),
                Przedmiot("Dokumenty", 1, false, false)
            )
        ),
        Podroz(1, "Podroz", "01-06-2023", "07-06-2023",
            "Rybnik", "Rekreacja",
            mutableListOf<Przedmiot>(
                Przedmiot("Torebka", 1, false, false),
                Przedmiot("Chusteczka", 1, false, false)
            )
        )
    )

    var Kategorie = mutableListOf<Kategoria>()

}