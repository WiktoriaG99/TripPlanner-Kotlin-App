package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.apka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout główny

        val arrayAdapter: ArrayAdapter<*>
        val DaneAplikacjiZmienna = DaneAplikacji()

        //val PodrozeTablica = ArrayList<Podroz>()

        // TODO
        // Dopilnować, żeby przy tworzeniu podróży nie można było
        // stworzyć dwóch podrozy o takiej samej nazwie
        // bo szukamy po nazwie podrozy
        // (dać komunikat przy tworzeniu a nie error)
        val PodrozeTablica = ArrayList<String>()

        for (item in DaneAplikacjiZmienna.Podroze) {
            PodrozeTablica.add(item.Nazwa)
        }


        var ListViewPodroze = binding.ListaPodrozy
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, PodrozeTablica
        )
        ListViewPodroze.adapter = arrayAdapter


        binding.ListaPodrozy.setOnItemClickListener { parent, view, position, id ->
            val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
            // TODO
            // na podstawir nazwy  znaleźć item z tablicy Podrozy
            // i przez put extra przeniesc dane do nastepnej aktywnosci
            //intencja.putExtra("WYSZUKIWANE_ZWIERZE", wyszukiwaneZwierze)

            for (item in DaneAplikacjiZmienna.Podroze) {
                if (item.Nazwa == ListViewPodroze.getItemAtPosition(position).toString()) {
                    intencja.putExtra("ID", item.ID)
                    intencja.putExtra("NAZWA", item.Nazwa)
                    intencja.putExtra("DATA_ROZPOCZECIA", item.DataRozpoczecia)
                    intencja.putExtra("DATA_ZAKONCZENIA", item.DataZakonczenia)
                    intencja.putExtra("MIEJSCOWOSC", item.Miejscowosc)
                    intencja.putExtra("TYP_PODROZY", item.TypPodrozy)
                    intencja.putExtra("PRZEDMIOTY", item.ListaPrzedmiotow)
                }
                startActivity(intencja)
            }
        }
    }
}