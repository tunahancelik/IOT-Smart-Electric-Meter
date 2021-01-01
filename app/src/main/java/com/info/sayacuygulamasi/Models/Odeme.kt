package com.info.sayacuygulamasi.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Odeme (@SerializedName("sayac_id")
             @Expose
             var sayac_id:Int
             ,
             @SerializedName("Ocak")
             @Expose
             var Ocak:Double
             ,
             @SerializedName("Şubat")
             @Expose
             var Şubat:Double
             ,
             @SerializedName("Mart")
             @Expose
             var Mart:Double
             ,
             @SerializedName("Nisan")
             @Expose
             var Nisan:Double
             ,
             @SerializedName("Mayıs")
             @Expose
             var Mayıs:Double
             ,
             @SerializedName("Haziran")
             @Expose
             var Haziran:Double
             ,
             @SerializedName("Temmuz")
             @Expose
             var Temmuz:Double
             ,
             @SerializedName("Ağustos")
             @Expose
             var Ağustos:Double
             ,
             @SerializedName("Eylül")
             @Expose
             var Eylül:Double
             ,
             @SerializedName("Ekim")
             @Expose
             var Ekim:Double
             ,
             @SerializedName("Kasım")
             @Expose
             var Kasım:Double ){
}