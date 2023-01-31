package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.memeapi.databinding.ActivityCrearTagBinding
import com.example.memeapi.response.MemeRetrofitInstance
import com.example.memeapi.response.TagDto
import com.example.memeapi.response.TagResponse
import retrofit2.*


class CrearTag : AppCompatActivity() {
    private lateinit var binding: ActivityCrearTagBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_tag)
        binding= ActivityCrearTagBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    fun crearTag(view:View){
        var tag = TagDto(binding.crearTag.text.toString())
        MemeRetrofitInstance.api.crearTag("/tag", tag).enqueue(object :Callback<TagResponse> {
            override fun onResponse(call: Call<TagResponse>, response: Response<TagResponse>) {
                if(response.body()!=null){
                intent=Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                }
            }

            override fun onFailure(call: Call<TagResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }

        })
    }
}