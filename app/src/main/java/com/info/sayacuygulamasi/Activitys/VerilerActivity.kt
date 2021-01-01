package com.info.sayacuygulamasi.Activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.retrofitkullanimi.ApiUtils
import com.info.sayacuygulamasi.Models.Odeme
import com.info.sayacuygulamasi.Models.OdemeCevap
import com.info.sayacuygulamasi.Models.SayaclarDaoInterface
import com.info.sayacuygulamasi.Models.VeriCevap
import com.info.sayacuygulamasi.R
import kotlinx.android.synthetic.main.activity_odeme.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerilerActivity : AppCompatActivity() {

    private lateinit var kdi: SayaclarDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veriler)

        val sayacNo = intent.getStringExtra("id")



        kdi = ApiUtils.getSayaclarDaoInterface()



        aramaYap(Integer.parseInt(sayacNo))


    }
    fun aramaYap(sayacNo:Int){

        kdi.sayacAra3(sayacNo).enqueue(object : Callback<VeriCevap> {

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<VeriCevap>?, response: Response<VeriCevap>?) {

                if(response != null) {
                    val liste = response.body().sayac_id

                    ocakText.setText(String.format("%.2f",liste.get(0).Ocak)+" kWt")
                    subatText.setText(String.format("%.2f",liste.get(0).Şubat)+" kWt")
                    martText.setText(String.format("%.2f",liste.get(0).Mart)+" kWt")
                    nisanText.setText(String.format("%.2f",liste.get(0).Nisan)+" kWt")
                    mayisText.setText(String.format("%.2f",liste.get(0).Mayıs)+" kWt")
                    haziranText.setText(String.format("%.2f",liste.get(0).Haziran)+" kWt")
                    temmuzText.setText(String.format("%.2f",liste.get(0).Temmuz)+" kWt")
                    agostosText.setText(String.format("%.2f",liste.get(0).Ağustos)+" kWt")
                    eylulText.setText(String.format("%.2f",liste.get(0).Eylül)+" kWt")
                    ekimText.setText(String.format("%.2f",liste.get(0).Ekim)+" kWt")
                    kasimText.setText(String.format("%.2f",liste.get(0).Kasım)+" kWt")

                    val toplam=liste.get(0).Ocak+liste.get(0).Şubat+liste.get(0).Mayıs+liste.get(0).Mart+liste.get(0).Nisan+liste.get(0).Haziran+liste.get(0).Temmuz+liste.get(0).Ağustos+liste.get(0).Ekim+liste.get(0).Eylül+liste.get(0).Kasım
                    toplamOdeme.setText(toplam.toInt().toString() + " kWt")

                    //rv.adapter = adapter
                    //Toast.makeText(applicationContext,liste.get(0).durum, Toast.LENGTH_SHORT).show()

                }

            }

            override fun onFailure(call: Call<VeriCevap>?, t: Throwable?) {

            }
        })
    }

}