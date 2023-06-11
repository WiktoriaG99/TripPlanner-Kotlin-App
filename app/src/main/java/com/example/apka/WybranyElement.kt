package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apka.databinding.ActivityUtworzElementBinding
import com.example.apka.databinding.ActivityWybranyElementBinding

class WybranyElement : AppCompatActivity() {
    lateinit var binding: ActivityWybranyElementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityWybranyElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idPodrozy = intent.getIntExtra("ID_PODROZY", 1)
        val DaneAplikacjiZmienna = DaneAplikacji()
        var nazwaPrzedmiotu = intent.getStringExtra("NAZWA_PRZEDMIOTU")
        binding.nazwaPrzedmiotu.setText(nazwaPrzedmiotu)
/*
        binding.ZapiszZmiany.setOnClickListener {
            for (item in DaneAplikacjiZmienna.Podroze) {
                if (item.ID == idPodrozy){
                    for(przedmiot in item.ListaPrzedmiotow)
                        if (przedmiot.NazwaPrzedmiotu == nazwaPrzedmiotu)
                        {
                            przedmiot.NazwaPrzedmiotu = binding.nazwaPrzedmiotu.text.toString()
                        }
                }
            }
            //TODO trzeba przerzucić wszystkie dane do Aktywna Podroz...?? albo nie i przerzucać na mainactivity lol
            val intencja = Intent(applicationContext, MainActivity::class.java)
            startActivity(intencja)
        }
        binding.UsunPrzedmiot.setOnClickListener {
            for (item in DaneAplikacjiZmienna.Podroze) {
                if (item.ID == idPodrozy){
                    for(przedmiot in item.ListaPrzedmiotow)
                        if (przedmiot.NazwaPrzedmiotu == nazwaPrzedmiotu)
                        {


                        }
                }
            }
        }


 */
    }
}