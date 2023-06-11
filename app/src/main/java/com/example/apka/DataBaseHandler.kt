package com.example.apka

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "MyDB"

val TABLE_NAME_PODROZE = "Podroze"
val COL_ID_PODROZ = "id_podroz"
val COL_NAZWA_PODROZ = "nazwa"
val COL_DATA_ROZPOCZECIA_PODROZ = "data_rozpoczecia"
val COL_DATA_ZAKONCZENIA_PODROZ = "data_zakonczenia"
val COL_MIEJSCOWOSC_PODROZ = "miejscowosc"
val COL_TYP_PODROZ = "typ"

val TABLE_NAME_PRZEDMIOTY = "Przedmioty"
val COL_ID_PRZEDMIOT = "id_przedmiot"
val COL_KATEGORIA_PRZEDMIOT = "kategoria"
val COL_NAZWA_PRZEDMIOT  = "nazwa"
val COL_LICZBA_PRZEDMIOT  = "liczba"
val COL_CZY_ZALEZNY_OD_DLUGOSCI_PODROZY = "czy_zalezny"
val COL_CZY_ZABRANY_PRZEDMIOT  = "czy_zabrany"

val TABLE_NAME_PODROZ_PRZEDMIOT = "Podroz_Przedmiot"
val COL_ID_PODROZ_PODROZ_PRZEDMIOT = "id_podroz"
val COL_ID_PRZEDMIOT_PODROZ_PRZEDMIOT= "id_przedmiot"

val TABLE_NAME_KATEGORIA = "Kategoria"
val COL_ID_KATEGORIA = "id_kategoria"
val COL_NAZWA_KATEGORIA  = "nazwa"

val TABLE_NAME_KATEGORIA_PRZEDMIOT = "KATEGORIA_Przedmiot"
val COL_ID_KATEGORIA_KATEGORIA_PRZEDMIOT = "id_kategoria"
val COL_ID_PRZEDMIOT_KATEGORIA_PRZEDMIOT= "id_przedmiot"

class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null,4){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME_PODROZE + " (" +
                COL_ID_PODROZ + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAZWA_PODROZ + " VARCHAR(256)," +
                COL_DATA_ROZPOCZECIA_PODROZ + " VARCHAR(256)," +
                COL_DATA_ZAKONCZENIA_PODROZ + " VARCHAR(256)," +
                COL_MIEJSCOWOSC_PODROZ + " VARCHAR(256)," +
                COL_TYP_PODROZ + " VARCHAR(256))";
        db?.execSQL(createTable)

        val createTablePrzedmioty = "CREATE TABLE " + TABLE_NAME_PRZEDMIOTY + " (" +
                COL_ID_PRZEDMIOT + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_KATEGORIA_PRZEDMIOT + " VARCHAR(256)," +
                COL_NAZWA_PRZEDMIOT + " VARCHAR(256)," +
                COL_LICZBA_PRZEDMIOT + " INTEGER," +
                COL_CZY_ZALEZNY_OD_DLUGOSCI_PODROZY + " INTEGER," +
                COL_CZY_ZABRANY_PRZEDMIOT + " INTEGER)";
        db?.execSQL(createTablePrzedmioty)

        var przedmiot = Przedmiot()
        przedmiot = Przedmiot("Samochód", "Kluczyki", 1, 0, 0)
        insertDataPrzedmiot(przedmiot)
        przedmiot = Przedmiot("Samochód", "Prawo jazdy", 1, 0, 0)
        insertDataPrzedmiot(przedmiot)

        val createTableKategorie = "CREATE TABLE " + TABLE_NAME_KATEGORIA + " (" +
                COL_ID_KATEGORIA + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAZWA_KATEGORIA + " VARCHAR(256))";
        db?.execSQL(createTableKategorie)

        var kategoria = Kategoria()
        kategoria = Kategoria("Samochód")
        insertDataKategoria(kategoria)
        kategoria = Kategoria("Samolot")
        insertDataKategoria(kategoria)
        kategoria = Kategoria("Komunikacja publiczna")
        insertDataKategoria(kategoria)

        val createTableKategoriaPrzedmiot = "CREATE TABLE " + TABLE_NAME_KATEGORIA_PRZEDMIOT + " (" +
                COL_ID_KATEGORIA_KATEGORIA_PRZEDMIOT + " INTEGER," +
                COL_ID_PRZEDMIOT_KATEGORIA_PRZEDMIOT + " INTEGER)";
        db?.execSQL(createTableKategoriaPrzedmiot)

        var kategoriaPrzedmiot = KategoriaPrzedmiot()
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 1)
        insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 2)
        insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)
        kategoriaPrzedmiot = KategoriaPrzedmiot(1, 3)
        insertDataKategoriaPrzedmiot(kategoriaPrzedmiot)

        val createTablePodrozPrzedmiot = "CREATE TABLE " + TABLE_NAME_PODROZ_PRZEDMIOT + " (" +
                COL_ID_PODROZ_PODROZ_PRZEDMIOT + " INTEGER," +
                COL_ID_PRZEDMIOT_PODROZ_PRZEDMIOT + " INTEGER)";
        db?.execSQL(createTablePodrozPrzedmiot)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertDataPodroz(podroz: Podroz){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAZWA_PODROZ, podroz.Nazwa)
        cv.put(COL_DATA_ROZPOCZECIA_PODROZ, podroz.DataRozpoczecia)
        cv.put(COL_DATA_ZAKONCZENIA_PODROZ, podroz.DataZakonczenia)
        cv.put(COL_MIEJSCOWOSC_PODROZ, podroz.Miejscowosc)
        cv.put(COL_TYP_PODROZ, podroz.TypPodrozy)

        var result = db.insert(TABLE_NAME_PODROZE, null, cv)
        if(result == -1.toLong())
            Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun insertDataPrzedmiot(przedmiot: Przedmiot)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_KATEGORIA_PRZEDMIOT, przedmiot.Kategoria)
        cv.put(COL_NAZWA_PRZEDMIOT, przedmiot.NazwaPrzedmiotu)
        cv.put(COL_LICZBA_PRZEDMIOT, przedmiot.Liczba)
        cv.put(COL_CZY_ZALEZNY_OD_DLUGOSCI_PODROZY, przedmiot.CzyZalezneOdDlugosciPodrozy)
        cv.put(COL_CZY_ZABRANY_PRZEDMIOT, przedmiot.CzyZaznaczony)
        db.insert(TABLE_NAME_PRZEDMIOTY, null, cv)
    }

    fun insertDataKategoria(kategoria: Kategoria)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAZWA_KATEGORIA, kategoria.Nazwa)
        db.insert(TABLE_NAME_KATEGORIA, null, cv)
    }

    fun insertDataKategoriaPrzedmiot(kategoriaPrzedmiot: KategoriaPrzedmiot)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_ID_KATEGORIA_KATEGORIA_PRZEDMIOT, kategoriaPrzedmiot.ID_Kategoria)
        cv.put(COL_NAZWA_KATEGORIA, kategoriaPrzedmiot.ID_Przedmiot)
        db.insert(TABLE_NAME_KATEGORIA_PRZEDMIOT, null, cv)
    }

    fun insertDataPodrozPrzedmiot(podroz: Podroz, przedmiot: Przedmiot)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_ID_PODROZ_PODROZ_PRZEDMIOT, podroz.ID)
        cv.put(COL_ID_PRZEDMIOT_PODROZ_PRZEDMIOT, przedmiot.ID)
        db.insert(TABLE_NAME_PODROZ_PRZEDMIOT, null, cv)
    }

    fun readDataPodroz() : MutableList<Podroz>{
        var list: MutableList<Podroz> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME_PODROZE
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do {
                var podroz = Podroz()
                podroz.ID = result.getString(0).toInt()
                podroz.Nazwa = result.getString(1)
                podroz.DataRozpoczecia = result.getString(2)
                podroz.DataZakonczenia = result.getString(3)
                podroz.Miejscowosc = result.getString(4)
                podroz.TypPodrozy = result.getString(5)
                list.add(podroz)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun readDataIDPodroz(nazwa:String): Int{
        var ID = 0
        val db = this.readableDatabase
        val query = "Select " + COL_ID_PODROZ + " from " + TABLE_NAME_PODROZE + " WHERE " + COL_NAZWA_PODROZ + "='" + nazwa + "'"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do {
            ID = result.getString(0).toInt()
            }while (result.moveToNext())
        }
        return ID
    }

}