package com.example.apka

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apka.databinding.ActivityTworzeniePodrozyBinding
import com.example.apka.databinding.ActivityWyborKategoriiBinding

class WyborKategorii : AppCompatActivity() {
    lateinit var binding: ActivityWyborKategoriiBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityWyborKategoriiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DaneAplikacjiZmienna = SpisKategorii()

        // Kategoria - Zakwaterowanie
        val arrayAdapterZakwaterowanie: ArrayAdapter<*>
        val KategoriaZakwaterowanieTablica = ArrayList<String>()

        for (item in DaneAplikacjiZmienna.Zakwaterowanie) {
            KategoriaZakwaterowanieTablica.add(item.Nazwa)
        }

        var ListViewZakwaterowanie = binding.lvZakwaterowanie
        arrayAdapterZakwaterowanie = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, KategoriaZakwaterowanieTablica
        )
        ListViewZakwaterowanie.adapter = arrayAdapterZakwaterowanie

        // Kategoria - Transport
        val arrayAdapterTransport: ArrayAdapter<*>
        val KategoriaTransportTablica = ArrayList<String>()

        for (item in DaneAplikacjiZmienna.Przewozy) {
            KategoriaTransportTablica.add(item.Nazwa)
        }

        var ListViewTransport = binding.lvTransport
        arrayAdapterTransport = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, KategoriaTransportTablica
        )
        ListViewTransport.adapter = arrayAdapterTransport


        // Kategoria - Zajecia/Przedmioty
        val arrayAdapterZajeciaPrzedmioty: ArrayAdapter<*>
        val KategoriaZajeciaPrzedmiotyTablica = ArrayList<String>()

        for (item in DaneAplikacjiZmienna.ZajeciaPrzedmioty) {
            KategoriaZajeciaPrzedmiotyTablica.add(item.Nazwa)
        }

        var ListViewZajeciaPrzedmioty = binding.lvZajeciaPrzedmioty
        arrayAdapterZajeciaPrzedmioty = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, KategoriaZajeciaPrzedmiotyTablica
        )
        ListViewZajeciaPrzedmioty.adapter = arrayAdapterZajeciaPrzedmioty

        // Kategoria - Inne
        val arrayInnePrzedmioty: ArrayAdapter<*>
        val KategoriaInneTablica = ArrayList<String>()

        for (item in DaneAplikacjiZmienna.Inne) {
            KategoriaInneTablica.add(item.Nazwa)
        }

        var ListViewInne = binding.lvInne
        arrayInnePrzedmioty = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, KategoriaInneTablica
        )
        ListViewInne.adapter = arrayInnePrzedmioty


        binding.DodajPodroz.setOnClickListener {

            var idNowejPodrozy = intent.getIntExtra("ID", -1)
            var nazwaNowejPodrozy = intent.getStringExtra("NAZWA")
            var miejscowoscNowejPodrozy = intent.getStringExtra("MIEJSCOWOSC")
            var dataRozpoczeciaNowejPodrozy = intent.getStringExtra("DATA_ROZPOCZECIA")
            var dataZakonczenaiNowejPodrozy = intent.getStringExtra("DATA_ZAKOCZENIA")
            var typNowejPodrozy = intent.getStringExtra("TYP_PODROZY")


            val DaneAplikacjiZmienna = DaneAplikacji()
            if(nazwaNowejPodrozy!=null && miejscowoscNowejPodrozy!=null && dataRozpoczeciaNowejPodrozy!=null
                && dataZakonczenaiNowejPodrozy!=null && typNowejPodrozy!=null) {
                DaneAplikacjiZmienna.Podroze.add(
                    Podroz(
                        idNowejPodrozy,
                        nazwaNowejPodrozy,
                        miejscowoscNowejPodrozy,
                        dataRozpoczeciaNowejPodrozy,
                        dataZakonczenaiNowejPodrozy,
                        typNowejPodrozy,
                        mutableListOf<Przedmiot>()
                    )
                )
            }

            Toast.makeText(this, "Dodano podróż", Toast.LENGTH_LONG).show();
            //Toast.makeText(this, DaneAplikacjiZmienna.Podroze.size.toString(), Toast.LENGTH_LONG).show();
            val intencja = Intent(applicationContext, MainActivity::class.java)
            startActivity(intencja)
        }

    }
}