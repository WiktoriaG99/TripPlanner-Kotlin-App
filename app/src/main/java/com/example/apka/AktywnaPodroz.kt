package com.example.apka

import android.R
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apka.databinding.ActivityAktywnaPodrozBinding

class AktywnaPodroz : AppCompatActivity() {
    lateinit var binding: ActivityAktywnaPodrozBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityAktywnaPodrozBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)

        // NAZWA - nazwa podróźy
        if(intent.hasExtra("NAZWA"))
        {
            var aktywnaPodroz = db.readDataPodrozByName(intent.getStringExtra("NAZWA").toString())

            binding.NazwaPodrozy.text = aktywnaPodroz.Nazwa
            binding.DataRozpoczecia.text = aktywnaPodroz.DataRozpoczecia
            binding.DataZakonczenia.text = aktywnaPodroz.DataZakonczenia
            binding.Miejscowosc.text = aktywnaPodroz.Miejscowosc
            binding.TypPodrozy.text = aktywnaPodroz.TypPodrozy

            val arrayAdapter: ArrayAdapter<*>

            //Pobranie przedmiotow danej podrozy
            var data = db.readDataPrzedmiotyPodrozy(aktywnaPodroz.ID)

            val PrzedmiotyTablica = mutableListOf<String>()

            for (i in 0..(data.size - 1)) {
                PrzedmiotyTablica.add(data.get(i))
            }

            var ListViewPodroze = binding.ListaPrzedmiotow
            arrayAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, PrzedmiotyTablica
            )
            ListViewPodroze.adapter = arrayAdapter


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

            binding.ListaPrzedmiotow.setOnItemLongClickListener { adapterView, view, i, l ->
                val intencja = Intent(applicationContext, WybranyElement::class.java)
                intencja.putExtra("NAZWA_PRZEDMIOTU", binding.ListaPrzedmiotow.getItemAtPosition(i).toString())
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                startActivity(intencja)
                true
            }

            binding.DodajPrzedmiot.setOnClickListener {
                val intencja = Intent(applicationContext, UtworzElement::class.java)
                intencja.putExtra("NAZWA", aktywnaPodroz.Nazwa)
                startActivity(intencja)

            }
        }
    }
}