package com.example.apka

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.size
import com.example.apka.databinding.ActivityAktywnaPodrozBinding

class AktywnaPodroz : AppCompatActivity() {
    lateinit var binding: ActivityAktywnaPodrozBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityAktywnaPodrozBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Odniesienie do bazy danych
        val db = DataBaseHandler(this)

        // NAZWA - nazwa podróźy
        if(intent.hasExtra("NAZWA"))
        {
            // Pobranie informacji o danej podróży do zmiennej
            var aktywnaPodroz = db.readDataPodrozByName(intent.getStringExtra("NAZWA").toString())

            val idPodrozy = aktywnaPodroz.ID

            // Przypisanie do elementów aktywności danych o podróży
            binding.NazwaPodrozy.text = aktywnaPodroz.Nazwa
            binding.DataRozpoczecia.text = aktywnaPodroz.DataRozpoczecia
            binding.DataZakonczenia.text = aktywnaPodroz.DataZakonczenia
            binding.Miejscowosc.text = aktywnaPodroz.Miejscowosc
            binding.TypPodrozy.text = aktywnaPodroz.TypPodrozy

            // Potrzebny do uzupełnienia listview
            val arrayAdapter: ArrayAdapter<*>

            //Pobranie przedmiotow danej podrozy
            var data = db.readDataPrzedmiotyPodrozy(aktywnaPodroz.ID)

            val PrzedmiotyLista = mutableListOf<String>()
            // Dodanie nazw przedmiotów do listy
            for (i in 0..(data.size - 1)) {
                PrzedmiotyLista.add(data.get(i))
            }

            // Dodanie przedmiotów do listview
            var ListViewPrzedmioty = binding.ListaPrzedmiotow
            arrayAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, PrzedmiotyLista
            )
            ListViewPrzedmioty.adapter = arrayAdapter

            // Zmiana koloru przedmiotów, które są zaznaczone jako zabrane
            for(i in 0..ListViewPrzedmioty.count-1)
            {
                var nazwa_Przedmiotu = ListViewPrzedmioty.getItemAtPosition(i).toString()
                var data = db.readDataCzyPrzedmiotZabrany(nazwa_Przedmiotu, idPodrozy)
                if (data.toInt() == 1)
                {
                    //TODO - if przedmiot o danej nazwie w sql ma czyZaznaczony==1 to wtedy zmiana koloru itemu
                    //ListViewPrzedmioty.adapter.getView(i, ListViewPrzedmioty, ListViewPrzedmioty).setBackgroundColor(Color.DKGRAY)
                    //ListViewPrzedmioty[i].setBackgroundColor(Color.DKGRAY)
                }

            }

            // Klikanie/odklikanie przedmiotów
            var CzyWybrany: Boolean = false
            binding.ListaPrzedmiotow.setOnItemClickListener { parent, view, position, id ->
                if(CzyWybrany == false)
                {
                    db.updateDataPrzedmiotZabrany(binding.ListaPrzedmiotow.getItemAtPosition(id.toInt()).toString(),1)
                    view.setBackgroundColor(Color.DKGRAY)
                    CzyWybrany = true
                }
                else
                {
                    db.updateDataPrzedmiotZabrany(binding.ListaPrzedmiotow.getItemAtPosition(id.toInt()).toString(),0)
                    view.setBackgroundColor(Color.WHITE)
                    CzyWybrany = false
                }
            }

            // Przytrzymanie przedmiotu przenosi do edycji - aktywności WybranyElement
            binding.ListaPrzedmiotow.setOnItemLongClickListener { adapterView, view, i, l ->
                val intencja = Intent(applicationContext, WybranyElement::class.java)
                intencja.putExtra("NAZWA_PRZEDMIOTU", binding.ListaPrzedmiotow.getItemAtPosition(i).toString())
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                intencja.putExtra("ID", aktywnaPodroz.ID)
                intencja.putExtra("DATA_ROZPOCZECIA", aktywnaPodroz.DataRozpoczecia)
                intencja.putExtra("DATA_ZAKONCZENIA", aktywnaPodroz.DataZakonczenia)
                startActivity(intencja)
                true
            }

            // Kliknięcie przenosi do aktywności Utwórz Element
            binding.DodajPrzedmiot.setOnClickListener {
                val intencja = Intent(applicationContext, UtworzElement::class.java)
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                intencja.putExtra("ID", aktywnaPodroz.ID)
                intencja.putExtra("DATA_ROZPOCZECIA", aktywnaPodroz.DataRozpoczecia)
                intencja.putExtra("DATA_ZAKONCZENIA", aktywnaPodroz.DataZakonczenia)
                startActivity(intencja)
            }
            binding.UsunPodroz.setOnClickListener {
                db.deleteDataPodroz(aktywnaPodroz.ID)
                Toast.makeText(this, "Usunięto podróż", Toast.LENGTH_SHORT).show()
                val intencja = Intent(applicationContext, MainActivity::class.java)
                startActivity(intencja)
            }
        }
    }
}