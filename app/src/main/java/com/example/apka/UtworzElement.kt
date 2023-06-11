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

        val IDPodrozy = intent.getIntExtra("ID", 1)

        //val DaneAplikacjiZmienna = DaneAplikacji()
        /*
        var aktywnaPodroz: Podroz = DaneAplikacjiZmienna.Podroze[IDPodrozy]

        var NazwaPrzedmiotuDoDodania = binding.NazwaElementu.text.toString()
        var LiczbaPrzedmiotuDoDodania = ""

        for (item in DaneAplikacjiZmienna.Podroze) {
            if (item.ID == IDPodrozy) {
                aktywnaPodroz = item
            }
        }

        binding.CzyLiczbaZaleznaOdDlugosciPodrozy.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = true
                val dataRozpoczeciaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ROZPOCZECIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                val dataZakonczeniaFormat = LocalDate.parse(
                    intent.getStringExtra("DATA_ZAKONCZENIA"),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")
                )
                var dni = ChronoUnit.DAYS.between(dataRozpoczeciaFormat, dataZakonczeniaFormat)
                LiczbaPrzedmiotuDoDodania = dni.toString()
                binding.LiczbaPrzedmiotow.setEnabled(false);
                binding.LiczbaPrzedmiotow.setCursorVisible(false);
                binding.LiczbaPrzedmiotow.setText(dni.toString())
            }
            else {
                binding.LiczbaPrzedmiotow.setEnabled(true);
                binding.LiczbaPrzedmiotow.setCursorVisible(true);
                var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = false
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString()
            }

            binding.DodajPrzedmiot.setOnClickListener {

                if (NazwaPrzedmiotuDoDodania == ""
                    || LiczbaPrzedmiotuDoDodania == ""
                ) {
                    Toast.makeText(
                        this,
                        "Wszystkie pola muszą zostać uzupełnione",
                        Toast.LENGTH_LONG
                    ).show();
                } else {
                    //Toast.makeText(this, "Dodano przedmiot do listy", Toast.LENGTH_LONG).show();

                    var nowyPrzedmiot =
                        Przedmiot(
                            NazwaPrzedmiotuDoDodania,
                            LiczbaPrzedmiotuDoDodania.toInt(),
                            false,
                            false
                        )


                    aktywnaPodroz.ListaPrzedmiotow.add(nowyPrzedmiot)


                    val intencja = Intent(applicationContext, AktywnaPodroz::class.java)
                    intencja.putExtra("ID", intent.getIntExtra("ID", 1))
                    intencja.putExtra("NAZWA", intent.getStringExtra("NAZWA"))
                    intencja.putExtra("DATA_ROZPOCZECIA", intent.getStringExtra("DATA_ROZPOCZECIA"))
                    intencja.putExtra("DATA_ZAKONCZENIA", intent.getStringExtra("DATA_ZAKONCZENIA"))
                    intencja.putExtra("MIEJSCOWOSC", intent.getStringExtra("MIEJSCOWOSC"))
                    intencja.putExtra("TYP_PODROZY", intent.getStringExtra("TYP_PODROZY"))
                    startActivity(intencja)
                }
            }
        }

         */
    }
}