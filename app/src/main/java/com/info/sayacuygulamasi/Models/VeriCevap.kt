package com.info.sayacuygulamasi.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VeriCevap (@SerializedName("sayac_id")
                 @Expose
                 var sayac_id:List<Veri>
                 ,
                 @SerializedName("success")
                 @Expose
                 var success:Int) {
}