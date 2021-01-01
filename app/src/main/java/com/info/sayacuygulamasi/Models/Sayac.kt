package com.info.sayacuygulamasi.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sayac(@SerializedName("sayac_id")
                     @Expose
                     var sayac_id:Int
                 ,
                 @SerializedName("durum")
                     @Expose
                     var durum:String
                 ,
                 @SerializedName("kullanilan")
                     @Expose
                     var kullanilan:Double)  {
}