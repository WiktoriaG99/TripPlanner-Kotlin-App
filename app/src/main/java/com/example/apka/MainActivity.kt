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

        //TODO - to tu nie moze być bo się tworzy za każdym wejściem w main activity,
        //TODO - ale w databasehandler nie działa i nw co z tym zrobić
        //-----------------------------------------------------------------------------------

        var przedmiot = Przedmiot()
        przedmiot = Przedmiot("Samochód", "Kluczyki", 1, 0, 0)
        db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samochód", "Prawo jazdy", 1, 0, 0)
        db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samolot", "Poduszka", 1, 0, 0)
        db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samolot", "Paszport", 1, 0, 0)
        db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Komunikacja publiczna", "Legitymacja", 1, 0, 0)
        db.insertDataPrzedmiot(przedmiot)

        // Transport
        var kategoria = Kategoria()
        kategoria = Kategoria("Samochód")
        db.insertDataKategoria(kategoria)
        kategoria = Kategoria("Samolot")
        db.insertDataKategoria(kategoria)
        kategoria = Kategoria("Komunikacja publiczna")
        db.insertDataKategoria(kategoria)

        var kategoriaPrzedmiot = KategoriaPrzedmiot()
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 1)
        db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 2)
        db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 3)
        db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 4)
        db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(3, 5)
        db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        //-----------------------------------------------------------------------------------

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
    }
}