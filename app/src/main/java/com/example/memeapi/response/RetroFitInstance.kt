package com.example.memeapi.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInstance {


    var url= "https://damemeapi.000webhostapp.com/"

        fun getInstance():Retrofit{
            return Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }

}