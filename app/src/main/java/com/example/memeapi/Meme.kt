package com.example.memeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.memeapi.databinding.ActivityMemeBinding
import com.example.memeapi.response.MemeResponse
import com.example.memeapi.response.MemeRetrofitInstance
import com.squareup.picasso.Picasso
import retrofit2.*


class Meme : AppCompatActivity() {
    private var binding: ActivityMemeBinding? = null
    private var lista = mutableListOf<MemeResponse>()
    private lateinit var id: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        id = intent.getStringExtra("idMeme").toString()
       verMeme(id)
    }

    fun verMeme(id:String) {

        MemeRetrofitInstance.api.getMeme("/meme?id=$id")
            .enqueue(object : Callback<MemeResponse> {
                override fun onResponse(
                    call: Call<MemeResponse>,
                    response: Response<MemeResponse>
                ) {
                    if (response.body() != null) {
                        //lista= response.body() as MutableList<MemeResponse>
                       // response.body()!!.nombre
                        binding?.titSup!!.text=  response.body()!!.titSup
                       binding?.titInf!!.text= response.body()!!.titInf
                        Picasso.get().load(response.body()!!.url).into(binding!!.foto)

                    }
                }

                override fun onFailure(call: Call<MemeResponse>, t: Throwable) {

                }
            })
    }
}