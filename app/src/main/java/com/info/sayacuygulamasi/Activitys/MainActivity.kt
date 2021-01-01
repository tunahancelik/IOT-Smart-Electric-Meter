package com.info.sayacuygulamasi.Activitys

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntegerRes
import com.info.retrofitkullanimi.ApiUtils
import com.info.sayacuygulamasi.Models.Sayac
import com.info.sayacuygulamasi.Models.SayaclarCevap
import com.info.sayacuygulamasi.Models.SayaclarDaoInterface
import com.info.sayacuygulamasi.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity()  {

    private lateinit var sayacListe:ArrayList<Sayac>

    private lateinit var sdi: SayaclarDaoInterface
    var deger:Double = 0.0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sayacNo = Integer.parseInt(intent.getStringExtra("id"))
        t1.setText("Sayaç Numarası: "+intent.getStringExtra("id"))

        sdi = ApiUtils.getSayaclarDaoInterface()
        aramaYap(sayacNo)



        val sp = getSharedPreferences("GirisBilgisi", Context.MODE_PRIVATE)



        odemeButton.setOnClickListener {
            val ogka = sp.getString("id","")


            val intent = Intent(this, OdemeActivity::class.java)
            intent.putExtra("id", ogka)
            startActivity(intent)
        }
        verilerButton.setOnClickListener {
            val ogka = sp.getString("id","")


            val intent = Intent(this, VerilerActivity::class.java)
            intent.putExtra("id", ogka)
            startActivity(intent)
        }
        ayarButton.setOnClickListener {
            val ogka = sp.getString("id","")


            val intent = Intent(this, AyarActivity::class.java)
            intent.putExtra("id", ogka)
            startActivity(intent)
        }
    }
    fun aramaYap(sayacNo:Int){
        sdi.sayacAra(sayacNo).enqueue(object : Callback<SayaclarCevap>{


            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<SayaclarCevap>?, response: Response<SayaclarCevap>?) {


                if (response != null) {
                    if(response.isSuccessful){
                        val liste =response.body().sayac_id

                        kullanim.setText(String.format("%.1f",(liste.get(0).kullanilan*0.7514))+" TL")
                        deger=liste.get(0).kullanilan
                        val sp = getSharedPreferences("GirisBilgisi", Context.MODE_PRIVATE)
                        val limitim = sp.getString("limit","")?.let { Integer.parseInt(it) }
                        if (limitim != null) {
                            hesaplaLimit(limitim,deger)
                        }
                        println(deger)
                    }else{
                        println("başarısız")
                    }
                }
            }
            override fun onFailure(call: Call<SayaclarCevap>?, t: Throwable?) {

            }
        })
    }

    @SuppressLint("SetTextI18n")
    fun hesaplaLimit(limit:Int,deger:Double){
        val fiyat=0.70

        val tutar=deger/fiyat
        val islem=(tutar*100)/limit


        if(tutar>=0) {
            circularProgressBar.progress = islem.toFloat()
            yuzdelik.setText("%"+String.format("%.0f",islem))
        }else{
            circularProgressBar.progress =100f
        }
    }
}
