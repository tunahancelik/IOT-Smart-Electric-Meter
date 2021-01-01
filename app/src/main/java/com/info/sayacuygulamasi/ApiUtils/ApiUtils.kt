package com.info.retrofitkullanimi

import com.info.sayacuygulamasi.Models.SayaclarDaoInterface


class ApiUtils {

    companion object{

        val BASE_URL = "http://142.93.167.245:8000"

        fun getSayaclarDaoInterface(): SayaclarDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(SayaclarDaoInterface::class.java)
        }
    }
}



