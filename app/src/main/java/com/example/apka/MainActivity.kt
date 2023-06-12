package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.apka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)

        // Potrzebne do uzupełnienia listview
        val arrayAdapter: ArrayAdapter<*>
        // Pobranie danych z bazy danych
        var data = db.readDataPodroz()
        val PodrozeLista = mutableListOf<String>()

        // Uzupełnienie listy nazwami Podróży
        for (i in 0..(data.size - 1)) {
            PodrozeLista.add(data.get(i).Nazwa)
        }

        // Dodanie podróży do listview
        var ListViewPodroze = binding.ListaPodrozy
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, PodrozeLista
        )
        ListViewPodroze.adapter = arrayAdapter

        // Po kliknięciu podróży przenosi na aktywność Aktywna Podróż
        // Nazwa może działać jak ID, bo jest unikalna
        binding.ListaPodrozy.setOnItemClickListener { parent, view, position, id ->
            val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
            intencja.putExtra("NAZWA", binding.ListaPodrozy.getItemAtPosition(position).toString())
            startActivity(intencja)
        }

        // Kliknięcie przenosi do aktywnosci Tworzenie Podróży
        binding.DodajPodroz.setOnClickListener {
            val intencja = Intent(applicationContext, TworzeniePodrozy::class.java)
            startActivity(intencja)
        }



        //------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Dodanie danych do bazy


        var przedmiot = Przedmiot("Hotel", "Suszarka", 1, 0, 0)
        var result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kemping", "Śpiwór", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kemping", "Poduszka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Samochód", "Kluczyki", 1, 0, 0) // - dane obiektu
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu) // - result jako wynik z bazy czy już coś istnieje takiego (o takiej nazwie)
        if(result==0) // - jeżeli nie istnieje w bazie (czyli 0) - to można dodać do bazy
            db.insertDataPrzedmiot(przedmiot) // - dodanie obiektu do bazy

        przedmiot = Przedmiot("Samochód", "Prawo jazdy", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Samolot", "Poduszka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Samolot", "Paszport", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Komunikacja publiczna", "Legitymacja", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Portfel", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Telefon", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Ładowarka do telefonu", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Laptop", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Ładowarka do laptopa", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Niezbędne rzeczy", "Leki", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Koszulka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Spodnie", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Bielizna", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Skarpety", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Buty", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Ubrania", "Bielizna", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kosmetyki", "Szampon", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kosmetyki", "Żel do mycia", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kosmetyki", "Pasta do zębów", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kosmetyki", "Szczoteczka do zębów", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Kosmetyki", "Szczotka do włosów", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Sporty zimowe", "Kurtka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Sporty zimowe", "Czapka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Sporty zimowe", "Szalik", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Sporty zimowe", "Rękawiczki", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Plaża", "Strój kąpielowy", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Plaża", "Ręcznik", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        przedmiot = Przedmiot("Plaża", "Krem z filtrem", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result==0)
            db.insertDataPrzedmiot(przedmiot)

        // Zakwaterowanie

        var kategoria = Kategoria("Hotel")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Kemping")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Bliscy")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        // Transport
        kategoria = Kategoria("Samochód")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Samolot")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Komunikacja publiczna")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        // Zajecia/Przedmioty

        kategoria = Kategoria("Niezbędne rzeczy")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Ubrania")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Kosmetyki")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Sporty zimowe")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)

        kategoria = Kategoria("Plaża")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result==0)
            db.insertDataKategoria(kategoria)


        // Hotel - 1
        var kategoriaPrzedmiot = KategoriaPrzedmiot(1, 1)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Kemping - 2

        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 2)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 3)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Bliscy - 3
        // Samochód - 4
        kategoriaPrzedmiot = KategoriaPrzedmiot(4, 4)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(4, 5)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Samolot - 5
        kategoriaPrzedmiot = KategoriaPrzedmiot(5, 6)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(5, 7)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Komunikacja publiczna - 6
        kategoriaPrzedmiot = KategoriaPrzedmiot(6, 8)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Niezbędne rzeczy - 7
        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 9)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 10)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 11)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 12)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 13)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(7, 14)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Ubrania - 8
        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 15)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 16)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 17)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 18)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 19)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(8, 20)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Kosmetyki - 9
        kategoriaPrzedmiot = KategoriaPrzedmiot(9, 21)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(9, 22)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(9, 23)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(9, 24)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(9, 25)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Sporty zimowe - 10
        kategoriaPrzedmiot = KategoriaPrzedmiot(10, 26)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(10, 27)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(10, 28)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(10, 29)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        // Plaża - 11
        kategoriaPrzedmiot = KategoriaPrzedmiot(11, 30)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(11, 31)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        kategoriaPrzedmiot = KategoriaPrzedmiot(11, 32)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

    }
}