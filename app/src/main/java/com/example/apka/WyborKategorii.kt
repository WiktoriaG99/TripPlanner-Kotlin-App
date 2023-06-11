package com.example.apka

import android.R
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apka.databinding.ActivityWyborKategoriiBinding

class WyborKategorii : AppCompatActivity() {
    lateinit var binding: ActivityWyborKategoriiBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityWyborKategoriiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val DaneAplikacjiZmienna = SpisKategorii()

        var WybraneKategorie : MutableList<String> = mutableListOf<String>()

        val context = this
        var db = DataBaseHandler(context)

        // Kategoria - Transport
        val arrayAdapterTransport: ArrayAdapter<*>
        val KategoriaTransportTablica = ArrayList<String>()

        KategoriaTransportTablica.add("Samochód")
        KategoriaTransportTablica.add("Samolot")
        KategoriaTransportTablica.add("Komunikacja publiczna")

        var ListViewTransport = binding.lvTransport
        arrayAdapterTransport = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, KategoriaTransportTablica
        )
        ListViewTransport.adapter = arrayAdapterTransport

        var CzyWybrany: Boolean = false

        ListViewTransport.setOnItemClickListener { parent, view, position, id ->
                if(CzyWybrany == false)
                {
                    WybraneKategorie.add(position.toString())
                    view.setBackgroundColor(Color.DKGRAY)
                    CzyWybrany = true
                }
                else
                {
                    WybraneKategorie.remove(position.toString())
                    view.setBackgroundColor(Color.WHITE)
                    CzyWybrany = false
                }
        }

/*
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

         */

        binding.DodajPodroz.setOnClickListener {

            var nazwaNowejPodrozy = intent.getStringExtra("NAZWA").toString()
            var miejscowoscNowejPodrozy = intent.getStringExtra("MIEJSCOWOSC").toString()
            var dataRozpoczeciaNowejPodrozy = intent.getStringExtra("DATA_ROZPOCZECIA").toString()
            var dataZakonczeniaNowejPodrozy = intent.getStringExtra("DATA_ZAKONCZENIA").toString()
            var typNowejPodrozy = intent.getStringExtra("TYP_PODROZY").toString()

            val db = DataBaseHandler(this)

            if(nazwaNowejPodrozy!=null && miejscowoscNowejPodrozy!=null && dataRozpoczeciaNowejPodrozy!=null
                && dataZakonczeniaNowejPodrozy!=null) {

                var podrozDoBazy = Podroz(
                    nazwaNowejPodrozy,
                    dataRozpoczeciaNowejPodrozy,
                    dataZakonczeniaNowejPodrozy,
                    miejscowoscNowejPodrozy,
                    typNowejPodrozy
                )

                db.insertDataPodroz(podrozDoBazy)


                //TODO dodanie kategorii i przedmiotow z niej

                //pobranie wszystkich przedmiotow z kategorii i przypisanie ich do tablicy

                var ID_podrozy = db.readDataIDPodroz(nazwaNowejPodrozy)




                Toast.makeText(this, "Dodano podróż", Toast.LENGTH_LONG).show();
                val intencja = Intent(applicationContext, MainActivity::class.java)
                startActivity(intencja)
            }
            else
            {
                Toast.makeText(this, "Coś poszło nie tak", Toast.LENGTH_LONG).show();
            }
        }

    }
}