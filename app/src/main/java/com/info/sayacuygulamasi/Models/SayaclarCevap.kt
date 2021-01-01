package com.info.sayacuygulamasi.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.info.sayacuygulamasi.Models.Sayac

data class SayaclarCevap(@SerializedName("sayac_id")
                          @Expose
                          var sayac_id:List<Sayac>
                         ,
                         @SerializedName("success")
                          @Expose
                          var success:Int) {
}