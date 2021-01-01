package com.info.sayacuygulamasi.Models

import com.info.sayacuygulamasi.Models.OdemeCevap
import com.info.sayacuygulamasi.Models.SayaclarCevap
import retrofit2.Call
import retrofit2.http.*

interface SayaclarDaoInterface {

    @POST("request3")
    @FormUrlEncoded
    fun sayacAra3(@Field("mid") mid:Int) : Call<VeriCevap>

    @POST("request2")
    @FormUrlEncoded
    fun sayacAra2(@Field("mid") mid:Int) : Call<OdemeCevap>



    @POST("request1")
    @FormUrlEncoded
    fun sayacAra(@Field("mid") mid:Int) : Call<SayaclarCevap>
}