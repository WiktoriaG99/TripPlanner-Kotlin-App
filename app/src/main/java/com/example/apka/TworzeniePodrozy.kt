package com.example.apka

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apka.databinding.ActivityTworzeniePodrozyBinding

class TworzeniePodrozy : AppCompatActivity() {
    lateinit var binding: ActivityTworzeniePodrozyBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // Inicjalizacja binding
        binding = ActivityTworzeniePodrozyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBaseHandler(this)

        var nazwaPodrozyZmienna = ""
        var miejscowoscZmienna = ""
        var dataRozpoczeciaZmienna = ""
        var dataZakonczeniaZmienna = ""
        var typPodrozyZmienna = ""

        binding.Dalej.setOnClickListener {

            nazwaPodrozyZmienna = binding.NazwaPodrozy.text.toString()
            miejscowoscZmienna = binding.Miejscowosc.text.toString()
            dataRozpoczeciaZmienna = binding.DataRozpoczecia.text.toString()
            dataZakonczeniaZmienna = binding.DataZakonczenia.text.toString()

            if(binding.TypPodrozy.isChecked) {
                typPodrozyZmienna = "Rekreacja"
            }
            else{
                typPodrozyZmienna = "Biznes"
            }

            if (nazwaPodrozyZmienna==""
                || miejscowoscZmienna==""
                || dataRozpoczeciaZmienna==""
                || dataZakonczeniaZmienna==""){

                Toast.makeText(this, "Wszystkie pola muszą zostać uzupełnione", Toast.LENGTH_LONG).show();
            }
            else {

                var CzyIstniejeJuzPodrozONazwie = false

                // Pobranie danych o Podróży o wprwaodzonej nazwie
                // Jeżeli takiej Podróży nie ma - tworzy się obiekt o wartościach wprowadzonych w klasie Podróź
                var data = db.readDataPodrozByName(nazwaPodrozyZmienna)

                // Pusty string to domyślna Nazwa dla Podróż z klasy Podróż
                if (data.Nazwa!="")
                {
                    CzyIstniejeJuzPodrozONazwie = true
                }

                if (CzyIstniejeJuzPodrozONazwie == true) {
                    Toast.makeText(this, "Już istnieje podróż o podanej nazwie", Toast.LENGTH_LONG).show();
                }
                else
                {
                    val intencja = Intent(applicationContext, WyborKategorii::class.java)
                    intencja.putExtra("NAZWA", nazwaPodrozyZmienna)
                    intencja.putExtra("DATA_ROZPOCZECIA", dataRozpoczeciaZmienna)
                    intencja.putExtra("DATA_ZAKONCZENIA", dataZakonczeniaZmienna)
                    intencja.putExtra("MIEJSCOWOSC", miejscowoscZmienna)
                    intencja.putExtra("TYP_PODROZY", typPodrozyZmienna)
                    startActivity(intencja)
                }
            }
        }
    }
}