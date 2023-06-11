package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apka.databinding.ActivityUtworzElementBinding
import com.example.apka.databinding.ActivityWybranyElementBinding

class WybranyElement : AppCompatActivity() {
    lateinit var binding: ActivityWybranyElementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityWybranyElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)
        val nazwaPodrozy = intent.getStringExtra("NAZWA")

        var nazwaPrzedmiotu = intent.getStringExtra("NAZWA_PRZEDMIOTU")
        var data = db.readDataPrzedmiot(nazwaPodrozy)


        binding.nazwaPrzedmiotu.setText(nazwaPrzedmiotu)
        if(data.CzyZalezneOdDlugosciPodrozy==1) {
            binding.CzyLiczbaZaleznaOdDlugosciPodrozy.isChecked = true
        }
        else{
            binding.CzyLiczbaZaleznaOdDlugosciPodrozy.isChecked = false
        }
        binding.LiczbaPrzedmiotow.setText(data.Liczba.toString())

        //TODO
        // Chyba nie działa przez to, że jest milion tych przedmiotów o tej samej nazwie, ale o rożnym id?
        // Bo te dodawanie trzeba ogarnąć w mainactivity
        // Może coś w stylu if juz w bazie danych to nie dodawaj? nw
        binding.ZapiszZmiany.setOnClickListener {

            var przedmiot = Przedmiot(
                data.ID,
            data.Kategoria ,
            data.NazwaPrzedmiotu,
            data.Liczba,
            data.CzyZalezneOdDlugosciPodrozy,
            data.CzyZaznaczony
            )
            db.updateDataPrzedmiot(przedmiot)
            Toast.makeText(this, "Zapisano zmiany", Toast.LENGTH_SHORT).show()
            val intencja = Intent(applicationContext, MainActivity::class.java)
            startActivity(intencja)
            }
        //TODO
        binding.UsunPrzedmiot.setOnClickListener {
            Toast.makeText(this, "Usunięto przedmiot", Toast.LENGTH_SHORT).show()
            val intencja = Intent(applicationContext, MainActivity::class.java)
            startActivity(intencja)
        }

    }
}