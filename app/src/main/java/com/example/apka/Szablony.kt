package com.example.apka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apka.databinding.ActivitySzablonyBinding

class Szablony : AppCompatActivity() {
    lateinit var binding: ActivitySzablonyBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivitySzablonyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout Szablony
    }
}