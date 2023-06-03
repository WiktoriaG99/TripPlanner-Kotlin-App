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
        var aktywnaPodroz: Podroz = DaneAplikacjiZmienna.Podroze[0]

        for (item in DaneAplikacjiZmienna.Podroze)
        {
            if(item.ID==IDPodrozy) {
                aktywnaPodroz = item
            }
        }

        binding.DodajPrzedmiot.setOnClickListener {

            val NazwaPrzedmiotuDoDodania = binding.NazwaElementu.text.toString()
            val LiczbaPrzedmiotuDoDodania = binding.LiczbaPrzedmiotow.text.toString()
            val CzyLiczbaZaleznaOdDlugosciPodrozyDoDodania = binding.CzyLiczbaZaleznaOdDlugosciPodrozy.text.toString()

            val nowyPrzedmiot = Przedmiot(NazwaPrzedmiotuDoDodania, LiczbaPrzedmiotuDoDodania.toInt(), false)
            //TODO OGARNAĆ CZEMU SIĘ NIE DODAJE
            aktywnaPodroz.ListaPrzedmiotow.plus(nowyPrzedmiot)


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