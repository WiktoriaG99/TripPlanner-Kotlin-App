package com.example.apka

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.apka.databinding.ActivityMainBinding
import com.example.apka.databinding.ActivityUtworzElementBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class UtworzElement : AppCompatActivity() {
    lateinit var binding: ActivityUtworzElementBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityUtworzElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)
        val nazwaPodrozy = intent.getStringExtra("NAZWA")


        var NazwaPrzedmiotuDoDodania = ""
        var LiczbaPrzedmiotuDoDodania = 0
        var czyZaznaczony = 0
        var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = 0

        binding.CzyLiczbaZaleznaOdDlugosciPodrozy.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString().toInt()
                CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = 1
                val dataRozpoczeciaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ROZPOCZECIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                val dataZakonczeniaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ZAKONCZENIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                var dni = ChronoUnit.DAYS.between(dataRozpoczeciaFormat, dataZakonczeniaFormat)
                LiczbaPrzedmiotuDoDodania = dni.toString().toInt()
                binding.LiczbaPrzedmiotow.setEnabled(false);
                binding.LiczbaPrzedmiotow.setCursorVisible(false);
                binding.LiczbaPrzedmiotow.setText(dni.toString())
            } else {
                binding.LiczbaPrzedmiotow.setEnabled(true);
                binding.LiczbaPrzedmiotow.setCursorVisible(true);
                CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = 0
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString().toInt()
            }

            binding.DodajPrzedmiot.setOnClickListener {
                NazwaPrzedmiotuDoDodania = binding.NazwaElementu.text.toString()
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString().toInt()
                if (NazwaPrzedmiotuDoDodania == ""
                    || LiczbaPrzedmiotuDoDodania.toString() == ""
                    || LiczbaPrzedmiotuDoDodania == 0
                ) {
                    Toast.makeText(
                        this,
                        "Wszystkie pola muszą zostać uzupełnione",
                        Toast.LENGTH_LONG
                    ).show();
                }
                else {

                    //TODO - sprawdzenie czy przedmiot o tej nazwie już nie znajduje sie w podrozy

                    Toast.makeText(this, "Dodano nowy przedmiot", Toast.LENGTH_LONG).show();

                    var nowyPrzedmiot =
                        Przedmiot(
                            NazwaPrzedmiotuDoDodania,
                            LiczbaPrzedmiotuDoDodania,
                            CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania,
                            czyZaznaczony
                        )

                    db.insertDataPrzedmiot(nowyPrzedmiot)
                    var przedmiot = db.readDataPrzedmiot(NazwaPrzedmiotuDoDodania)
                    db.insertDataPodrozPrzedmiot(intent.getIntExtra("ID",1),przedmiot.ID)

                    val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
                    intencja.putExtra("NAZWA", intent.getStringExtra("NAZWA"))
                    startActivity(intencja)
                }
            }
        }
    }
}