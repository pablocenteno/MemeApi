package com.example.memeapi.response


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {

    @GET
    fun dameMeme(@Url url:String):Response<MemeResponse>

    @GET
    fun dameMemes(@Url url:String):Response<MemeResponse>




}