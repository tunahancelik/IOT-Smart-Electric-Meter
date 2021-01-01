package com.info.sayacuygulamasi.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.info.sayacuygulamasi.Models.Odeme

class OdemeCevap (@SerializedName("sayac_id")
                  @Expose
                  var sayac_id:List<Odeme>
                  ,
                  @SerializedName("success")
                  @Expose
                  var success:Int) {
}