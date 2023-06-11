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

        val arrayAdapter: ArrayAdapter<*>

        val db = DataBaseHandler(this)
        var data = db.readDataPodroz()

        val PodrozeTablica = mutableListOf<String>()

        for (i in 0..(data.size - 1)) {
            PodrozeTablica.add(data.get(i).Nazwa)
        }

        var ListViewPodroze = binding.ListaPodrozy
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, PodrozeTablica
        )
        ListViewPodroze.adapter = arrayAdapter

        binding.ListaPodrozy.setOnItemClickListener { parent, view, position, id ->
            val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
            intencja.putExtra("NAZWA", binding.ListaPodrozy.getItemAtPosition(position).toString())
            startActivity(intencja)
        }

        binding.DodajPodroz.setOnClickListener {
            val intencja = Intent(applicationContext, TworzeniePodrozy::class.java)
            startActivity(intencja)
        }
    }
}