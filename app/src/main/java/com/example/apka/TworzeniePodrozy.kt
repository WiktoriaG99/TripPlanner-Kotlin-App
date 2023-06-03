package com.example.apka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apka.databinding.ActivityTworzeniePodrozyBinding

class TworzeniePodrozy : AppCompatActivity() {
    lateinit var binding: ActivityTworzeniePodrozyBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityTworzeniePodrozyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Layout Tworzenie Podróże
    }
}