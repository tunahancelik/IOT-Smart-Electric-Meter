package com.info.sayacuygulamasi.Activitys

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sayacuygulamasi.R
import kotlinx.android.synthetic.main.activity_sayac_no.*

class SayacNo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayac_no)
        val sp = getSharedPreferences("GirisBilgisi", Context.MODE_PRIVATE)
        val ogka = sp.getString("id","")
        val kont=sp.getString("id","3");


        if(ogka ==kont){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", ogka)
            startActivity(intent)
            finish()
        }

        sayacNoButton.setOnClickListener {
            val ka = sayacId.text.toString()
            val limit = limit.text.toString()

            val editor = sp.edit()
            editor.putString("id",ka)
            editor.putString("limit",limit)
            editor.commit()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", ka)
            intent.putExtra("limit", limit)
            startActivity(intent)
            finish()
        }

    }
}