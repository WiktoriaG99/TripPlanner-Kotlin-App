package com.example.apka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apka.databinding.ActivityAktywnaPodrozBinding

class AktywnaPodroz : AppCompatActivity() {
    lateinit var binding: ActivityAktywnaPodrozBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityAktywnaPodrozBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Wejście w Podróż z listy Podróży z listview

        if(intent.hasExtra("NAZWA"))
        {
            val nazwaPodrozy= intent.getStringExtra("NAZWA")
            Toast.makeText(this, nazwaPodrozy, Toast.LENGTH_LONG).show();
        }

    }
}