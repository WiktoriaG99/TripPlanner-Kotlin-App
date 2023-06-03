package com.example.apka

class DaneAplikacji {
    // Jak się robi pola klasy:
    //val num = arrayOf(1, 2, 3, 4)   //implicit type declaration
    //val num = arrayOf<int>(1, 2, 3, 4)   //implicit type declaration

    //Tabela tabel - Podróże, zawierające pojedyncze elementy Podroz
    public val Podroze = arrayOf(Podroz(1, "Wakacje", "01.06.2023", "07.06.2023", "Katowice", "Rekreacja"),
        Podroz(2, "Praca", "01.06.2023", "07.06.2023", "Bytom", "Biznes")
        )

    val Szablony = arrayOf<Szablon>()

    val Kategorie = arrayOf<Kategoria>()

}