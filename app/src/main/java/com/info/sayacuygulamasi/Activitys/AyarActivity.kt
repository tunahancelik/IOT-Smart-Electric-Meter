package com.info.sayacuygulamasi.Activitys

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.info.sayacuygulamasi.R
import kotlinx.android.synthetic.main.activity_ayar.*
import kotlinx.android.synthetic.main.activity_sayac_no.*

class AyarActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayar)

        val sp = getSharedPreferences("GirisBilgisi", Context.MODE_PRIVATE)
        val ogka = sp.getString("id","")
        val limitVeri = sp.getString("limit","")
        sayacNotText.setText(ogka)
        limitText.setText(limitVeri)

        kaydetButton.setOnClickListener {
            Toast.makeText(this@AyarActivity,"Verileriniz kaydedildi",Toast.LENGTH_SHORT).show()
            val ka = sayacNotText.text.toString()
            val limit = limitText.text.toString()

            val editor = sp.edit()
            editor.putString("id",ka)
            editor.putString("limit",limit)
            editor.apply()



        }
    }
}