package com.example.apka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apka.databinding.ActivityInformacjeBinding

class Informacje : AppCompatActivity() {
    lateinit var binding: ActivityInformacjeBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityInformacjeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout O Aplikacji
    }
}