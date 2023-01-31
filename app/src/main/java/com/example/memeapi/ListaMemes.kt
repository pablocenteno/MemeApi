package com.example.memeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapi.databinding.ActivityListaMemesBinding
import com.example.memeapi.recycler.ListaMemesAdapter
import com.example.memeapi.response.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

class ListaMemes : AppCompatActivity() {
    private lateinit var binding: ActivityListaMemesBinding
    private lateinit var adapter: ListaMemesAdapter
    private var lista = mutableListOf<MemeResponse>()
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaMemesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listarMemes(num)
        num+=5

    }

    private fun listarMemes( view: View, num: Int) {

      MemeRetrofitInstance.api.dameMemes("/meme/list?count=5&page=$num").enqueue(object : Callback<List<MemeResponse>>{
          override fun onResponse(
              call: Call<List<MemeResponse>>,
              response: Response<List<MemeResponse>>
          ) {
              if(response.body()!=null){
                  lista= response.body() as MutableList<MemeResponse>
                  adapter = ListaMemesAdapter(lista)

                  binding.recycler.layoutManager = LinearLayoutManager(applicationContext)
                  binding.recycler.adapter = adapter

              }
          }

          override fun onFailure(call: Call<List<MemeResponse>>, t: Throwable) {
              Log.d("TAG", t.message.toString())
          }
      })
    }


    private fun dame5(){

    }

}
