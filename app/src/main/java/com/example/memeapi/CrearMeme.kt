package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData

import com.example.memeapi.databinding.ActivityCrearMemeBinding
import com.example.memeapi.response.MemeDto
import com.example.memeapi.response.MemeResponse
import com.example.memeapi.response.MemeRetrofitInstance
import com.example.memeapi.response.TagResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CrearMeme : AppCompatActivity() {
    private lateinit var binding:ActivityCrearMemeBinding
    private var listaTags=mutableListOf<TagResponse>()

    private lateinit var crearNuevoMeme:MutableLiveData<MemeResponse>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_meme)
        binding=ActivityCrearMemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listarTag()
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaTags)
        binding.spinner.adapter=adaptador

    }

    private fun listarTag(){
        MemeRetrofitInstance.api.dameTags("/tag/list/").enqueue(object :Callback<List<TagResponse>>{
            override fun onResponse(
                call: Call<List<TagResponse>>,
                response: Response<List<TagResponse>>
            ) {
               if(response.body()!=null){
                    listaTags= response.body() as MutableList<TagResponse>
               }
            }

            override fun onFailure(call: Call<List<TagResponse>>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }

        })
    }

     fun crearMemo(view: View){
        var meme = MemeDto(binding.nombreMeme.text.toString(), binding.TituloSup.text.toString(),binding.tituloInf.text.toString(),binding.url.text.toString(),binding.spinner.toString())
        MemeRetrofitInstance.api.crearMeme("/meme",meme).enqueue(object :Callback<MemeResponse>{
            override fun onResponse(call: Call<MemeResponse>, response: Response<MemeResponse>) {
                if(response.body()!=null){
                    intent= Intent(applicationContext,Meme::class.java).apply {
                        putExtra("idMeme",response.body()!!.id.toString())
                    }
                    startActivity(intent)
                }

            }

            override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }


        })


    }
}