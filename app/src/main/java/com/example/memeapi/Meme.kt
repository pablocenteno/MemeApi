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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        verMeme(intent.getIntExtra("id", 0))
    }

    fun verMeme(id: Int) {

        MemeRetrofitInstance.api.getMeme("/meme?id=$id")
            .enqueue(object : Callback<MemeResponse> {
                override fun onResponse(
                    call: Call<MemeResponse>,
                    response: Response<MemeResponse>
                ) {
                    if (response.body() != null) {
                        lista= response.body() as MutableList<MemeResponse>

                        binding?.titSup!!.text= lista.get(3).toString()
                        binding?.titInf!!.text= lista.get(4).toString()
                        Picasso.get().load(lista.get(2).toString()).into(binding!!.foto)

                    }
                }

                override fun onFailure(call: Call<MemeResponse>, t: Throwable) {

                }
            })
    }
}