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

        //TODO - dodać resztę, może przenieść do innego pliku?
        //-----------------------------------------------------------------------------------

        var przedmiot = Przedmiot() // - inicjalizacja obiektu
        przedmiot = Przedmiot("Samochód", "Kluczyki", 1, 0, 0) // - dane obiektu
        var result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu) // - result jako wynik z bazy czy już coś istnieje takiego (o takiej nazwie)
        if(result.toInt()==0) // - jeżeli nie istnieje w bazie (czyli 0) - to można dodać do bazy
            db.insertDataPrzedmiot(przedmiot) // - dodanie obiektu do bazy
        przedmiot = Przedmiot("Samochód", "Prawo jazdy", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result.toInt()==0)
            db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samolot", "Poduszka", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result.toInt()==0)
            db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samolot", "Paszport", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result.toInt()==0)
            db.insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Komunikacja publiczna", "Legitymacja", 1, 0, 0)
        result = db.readDataCzyPrzedmiotnaLiscie(przedmiot.NazwaPrzedmiotu)
        if(result.toInt()==0)
            db.insertDataPrzedmiot(przedmiot)

        // Transport
        var kategoria = Kategoria()
        kategoria = Kategoria("Samochód")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result.toInt()==0)
            db.insertDataKategoria(kategoria)
        kategoria = Kategoria("Samolot")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result.toInt()==0)
            db.insertDataKategoria(kategoria)
        kategoria = Kategoria("Komunikacja publiczna")
        result = db.readDataCzyKategoriaNaLiscie(kategoria.Nazwa)
        if(result.toInt()==0)
            db.insertDataKategoria(kategoria)

        var kategoriaPrzedmiot = KategoriaPrzedmiot()
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 1)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result.toInt()==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 2)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result.toInt()==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 3)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result.toInt()==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(2, 4)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result.toInt()==0)
            db.insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(3, 5)
        result = db.readDataCzyKategoriaPrzedmiotNaLiscie(kategoriaPrzedmiot.ID_Kategoria, kategoriaPrzedmiot.ID_Przedmiot)
        if(result.toInt()==0)
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