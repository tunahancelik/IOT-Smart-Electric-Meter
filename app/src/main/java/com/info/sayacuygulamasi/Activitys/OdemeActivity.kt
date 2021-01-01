package com.info.sayacuygulamasi.Activitys

import com.info.sayacuygulamasi.R


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.retrofitkullanimi.ApiUtils
import com.info.sayacuygulamasi.Models.Odeme
import com.info.sayacuygulamasi.Models.OdemeCevap
import com.info.sayacuygulamasi.Models.SayaclarDaoInterface
import kotlinx.android.synthetic.main.activity_odeme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OdemeActivity : AppCompatActivity() {
    private lateinit var kelimelerListe:ArrayList<Odeme>

    private lateinit var kdi: SayaclarDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_odeme)
        val name = intent.getStringExtra("id")


        // rv.setHasFixedSize(true)
        // rv.layoutManager = LinearLayoutManager(this)

        kdi = ApiUtils.getSayaclarDaoInterface()



        aramaYap(Integer.parseInt(name))


    }
    fun aramaYap(aramaKelime:Int){

        kdi.sayacAra2(aramaKelime).enqueue(object : Callback<OdemeCevap> {

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<OdemeCevap>?, response: Response<OdemeCevap>?) {

                if(response != null) {
                    val liste = response.body().sayac_id

                    ocakText.setText(String.format("%.2f",liste.get(0).Ocak)+" TL")
                    subatText.setText(String.format("%.2f",liste.get(0).Şubat)+" TL")
                    martText.setText(String.format("%.2f",liste.get(0).Mart)+" TL")
                    nisanText.setText(String.format("%.2f",liste.get(0).Nisan)+" TL")
                    mayisText.setText(String.format("%.2f",liste.get(0).Mayıs)+" TL")
                    haziranText.setText(String.format("%.2f",liste.get(0).Haziran)+" TL")
                    temmuzText.setText(String.format("%.2f",liste.get(0).Temmuz)+" TL")
                    agostosText.setText(String.format("%.2f",liste.get(0).Ağustos)+" TL")
                    eylulText.setText(String.format("%.2f",liste.get(0).Eylül)+" TL")
                    ekimText.setText(String.format("%.2f",liste.get(0).Ekim)+" TL")
                    kasimText.setText(String.format("%.2f",liste.get(0).Kasım)+" TL")

                    val toplam=liste.get(0).Ocak+liste.get(0).Şubat+liste.get(0).Mayıs+liste.get(0).Mart+liste.get(0).Nisan+liste.get(0).Haziran+liste.get(0).Temmuz+liste.get(0).Ağustos+liste.get(0).Ekim+liste.get(0).Eylül+liste.get(0).Kasım
                    toplamOdeme.setText(toplam.toInt().toString() + " TL")

                    //rv.adapter = adapter
                    //Toast.makeText(applicationContext,liste.get(0).durum, Toast.LENGTH_SHORT).show()

                }

            }

            override fun onFailure(call: Call<OdemeCevap>?, t: Throwable?) {

            }
        })
    }
}