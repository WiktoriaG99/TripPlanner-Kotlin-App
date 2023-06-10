package com.example.apka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apka.databinding.ActivityMainBinding
import com.example.apka.databinding.ActivityUtworzElementBinding

class UtworzElement : AppCompatActivity() {
    lateinit var binding: ActivityUtworzElementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityUtworzElementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val IDPodrozy = intent.getIntExtra("ID", 1)

        val DaneAplikacjiZmienna = DaneAplikacji()
        var aktywnaPodroz: Podroz = DaneAplikacjiZmienna.Podroze[IDPodrozy]

        for (item in DaneAplikacjiZmienna.Podroze)
        {
            if(item.ID==IDPodrozy) {
                aktywnaPodroz = item
            }
        }

        binding.DodajPrzedmiot.setOnClickListener {

            var NazwaPrzedmiotuDoDodania = binding.NazwaElementu.text.toString()
            //TODO zrobić to na boola
            //var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = binding.CzyLiczbaZaleznaOdDlugosciPodrozy.text.toString()
            var LiczbaPrzedmiotuDoDodania = ""
            if(binding.CzyLiczbaZaleznaOdDlugosciPodrozy.isChecked()){
                var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = false
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString()
            }
            else{
                var CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = true
                LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString()
            }

            if(NazwaPrzedmiotuDoDodania == ""
                || LiczbaPrzedmiotuDoDodania == "") {
                Toast.makeText(this, "Wszystkie pola muszą zostać uzupełnione", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Dodano przedmiot do listy", Toast.LENGTH_LONG).show();

                var nowyPrzedmiot =
                    Przedmiot(NazwaPrzedmiotuDoDodania, LiczbaPrzedmiotuDoDodania.toInt(), false, false)
                //TODO OGARNAĆ CZEMU SIĘ NIE DODAJE
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
}