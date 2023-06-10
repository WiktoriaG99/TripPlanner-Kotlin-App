package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.apka.databinding.ActivityMainBinding
import java.util.Collections.list

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

        val PodrozeTablica = mutableListOf<String>()

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

            for (item in DaneAplikacjiZmienna.Podroze) {
                if (item.Nazwa == ListViewPodroze.getItemAtPosition(position).toString()) {
                    intencja.putExtra("ID", item.ID)
                    intencja.putExtra("NAZWA", item.Nazwa)
                    intencja.putExtra("DATA_ROZPOCZECIA", item.DataRozpoczecia)
                    intencja.putExtra("DATA_ZAKONCZENIA", item.DataZakonczenia)
                    intencja.putExtra("MIEJSCOWOSC", item.Miejscowosc)
                    intencja.putExtra("TYP_PODROZY", item.TypPodrozy)
                }
                startActivity(intencja)
            }
        }

        binding.DodajPodroz.setOnClickListener {
            val intencja = Intent(applicationContext, TworzeniePodrozy::class.java)
            startActivity(intencja)
        }

    }
}