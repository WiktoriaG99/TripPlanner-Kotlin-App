package com.example.apka

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.apka.databinding.ActivityWybranyElementBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class WybranyElement : AppCompatActivity() {
    lateinit var binding: ActivityWybranyElementBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityWybranyElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)
        val nazwaPodrozy = intent.getStringExtra("NAZWA")

        var nazwaPrzedmiotu = intent.getStringExtra("NAZWA_PRZEDMIOTU")
        var data = db.readDataPrzedmiot(nazwaPrzedmiotu)

        binding.nazwaPrzedmiotu.setText(nazwaPrzedmiotu)
        if(data.CzyZalezneOdDlugosciPodrozy==1) {
            binding.CzyLiczbaZaleznaOdDlugosciPodrozy.isChecked = true
            binding.LiczbaPrzedmiotow.setEnabled(false);
            binding.LiczbaPrzedmiotow.setCursorVisible(false);
        }
        else{
            binding.CzyLiczbaZaleznaOdDlugosciPodrozy.isChecked = false
        }
        binding.LiczbaPrzedmiotow.setText(data.Liczba.toString())

        binding.CzyLiczbaZaleznaOdDlugosciPodrozy.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                data.Liczba = binding.LiczbaPrzedmiotow.text.toString().toInt()
                data.CzyZalezneOdDlugosciPodrozy = 1
                val dataRozpoczeciaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ROZPOCZECIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                val dataZakonczeniaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ZAKONCZENIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                var dni = ChronoUnit.DAYS.between(dataRozpoczeciaFormat, dataZakonczeniaFormat)
                data.Liczba = dni.toString().toInt()
                binding.LiczbaPrzedmiotow.setEnabled(false);
                binding.LiczbaPrzedmiotow.setCursorVisible(false);
                binding.LiczbaPrzedmiotow.setText(dni.toString())
            } else {
                binding.LiczbaPrzedmiotow.setEnabled(true);
                binding.LiczbaPrzedmiotow.setCursorVisible(true);
                data.CzyZalezneOdDlugosciPodrozy = 0
                data.Liczba = binding.LiczbaPrzedmiotow.text.toString().toInt()
            }
        }
            binding.ZapiszZmiany.setOnClickListener {

                data.NazwaPrzedmiotu = binding.nazwaPrzedmiotu.text.toString()
                data.Liczba = binding.LiczbaPrzedmiotow.text.toString().toInt()

                var przedmiot = Przedmiot(
                    data.ID,
                    data.Kategoria,
                    data.NazwaPrzedmiotu,
                    data.Liczba,
                    data.CzyZalezneOdDlugosciPodrozy,
                    data.CzyZaznaczony
                )
                db.updateDataPrzedmiot(przedmiot)
                Toast.makeText(this, "Zapisano zmiany", Toast.LENGTH_SHORT).show()
                val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
                intencja.putExtra("NAZWA", nazwaPodrozy)

                startActivity(intencja)
            }
            binding.UsunPrzedmiot.setOnClickListener {
                Toast.makeText(this, "Usunięto przedmiot", Toast.LENGTH_SHORT).show()
                db.deleteDataPrzedmiot(data.ID.toInt())
                val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
                intencja.putExtra("NAZWA", nazwaPodrozy)

                startActivity(intencja)
            }

    }
}