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

        if(intent.hasExtra("NAZWA"))
        {
            binding.NazwaPodrozy.text = intent.getStringExtra("NAZWA")

            val ID = intent.getIntExtra("ID", 1)

            val arrayAdapter: ArrayAdapter<*>
            val DaneAplikacjiZmienna = DaneAplikacji()
/*
            val ListaPrzedmiotow = ArrayList<String>()
            var aktywnaPodroz: Podroz = DaneAplikacjiZmienna.Podroze[ID]

            for (item in DaneAplikacjiZmienna.Podroze)
            {
                if(item.ID==ID)
                    aktywnaPodroz = item
            }

            for (item in aktywnaPodroz.ListaPrzedmiotow) {
                ListaPrzedmiotow.add(item.NazwaPrzedmiotu)
            }

            var ListViewPrzedmioty = binding.ListaPrzedmiotow
            arrayAdapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, ListaPrzedmiotow
            )
            ListViewPrzedmioty.adapter = arrayAdapter
*/
        }

        var CzyWybrany: Boolean = false

        binding.ListaPrzedmiotow.setOnItemClickListener { parent, view, position, id ->
            if(CzyWybrany == false)
            {

                view.setBackgroundColor(Color.DKGRAY)
                CzyWybrany = true
            }
            else
            {
                view.setBackgroundColor(Color.WHITE)
                CzyWybrany = false
            }
        }

        binding.ListaPrzedmiotow.setOnItemLongClickListener { adapterView, view, i, l ->
            val intencja = Intent(applicationContext, WybranyElement::class.java)
            intencja.putExtra("NAZWA_PRZEDMIOTU", binding.ListaPrzedmiotow.getItemAtPosition(i).toString())
            intencja.putExtra("ID_PODROZY", intent.getIntExtra("ID", 1))
            startActivity(intencja)
            true
        }

        binding.DodajPrzedmiot.setOnClickListener {
            val intencja = Intent(applicationContext, UtworzElement::class.java)
            intencja.putExtra("ID", intent.getIntExtra("ID", 1))
            intencja.putExtra("NAZWA", intent.getStringExtra("NAZWA"))
            intencja.putExtra("DATA_ROZPOCZECIA", intent.getStringExtra("DATA_ROZPOCZECIA"))
            intencja.putExtra("DATA_ZAKONCZENIA", intent.getStringExtra("DATA_ZAKONCZENIA"))
            intencja.putExtra("MIEJSCOWOSC", intent.getStringExtra("MIEJSCOWOSC"))
            intencja.putExtra("TYP_PODROZY", intent.getStringExtra("TYP_PODROZY"))
            startActivity(intencja)

        }

    }
}