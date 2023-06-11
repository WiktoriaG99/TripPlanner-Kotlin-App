package com.example.apka

//TODO Do usunięcia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apka.databinding.ActivityTworzeniePodrozyBinding
import com.example.apka.databinding.ActivityUstawieniaBinding

class Ustawienia : AppCompatActivity() {
    lateinit var binding: ActivityUstawieniaBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityUstawieniaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout Ustawienia
    }
}