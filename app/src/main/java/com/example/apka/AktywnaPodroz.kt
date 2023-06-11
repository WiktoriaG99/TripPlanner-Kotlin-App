package com.example.apka

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

            // Klikanie/odklikanie przedmiotów
            var CzyWybrany: Boolean = false
            binding.ListaPrzedmiotow.setOnItemClickListener { parent, view, position, id ->
                if(CzyWybrany == false)
                {
                    //zmienić jego property czy zaznaczony na true
                    view.setBackgroundColor(Color.DKGRAY)
                    CzyWybrany = true
                }
                else
                {
                    //zmienić jego property czy zaznaczony na false
                    view.setBackgroundColor(Color.WHITE)
                    CzyWybrany = false
                }
            }

            // Przytrzymanie przedmiotu przenosi do edycji - aktywności WybranyElement
            binding.ListaPrzedmiotow.setOnItemLongClickListener { adapterView, view, i, l ->
                val intencja = Intent(applicationContext, WybranyElement::class.java)
                intencja.putExtra("NAZWA_PRZEDMIOTU", binding.ListaPrzedmiotow.getItemAtPosition(i).toString())
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                startActivity(intencja)
                true
            }

            // Kliknięcie przenosi do aktywności Utwórz Element
            binding.DodajPrzedmiot.setOnClickListener {
                val intencja = Intent(applicationContext, UtworzElement::class.java)
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                startActivity(intencja)

            }
        }
    }
}