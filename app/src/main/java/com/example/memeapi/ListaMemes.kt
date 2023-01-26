package com.example.memeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapi.databinding.ActivityListaMemesBinding
import com.example.memeapi.recycler.ListaMemesAdapter
import com.example.memeapi.response.APIService
import com.example.memeapi.response.MemeResponse
import com.example.memeapi.response.RetroFitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URI.create

class ListaMemes : AppCompatActivity() {
    private lateinit var binding: ActivityListaMemesBinding
    private lateinit var adapter: ListaMemesAdapter
    private val lista = mutableListOf<MemeResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_memes)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ListaMemesAdapter(lista)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }
    private fun getRetroFit():Retrofit{
        var url= "https://damemeapi.000webhostapp.com/"
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
    private fun listarMemes(query: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetroFit().create(APIService::class.java).dameMemes("$query/meme/list")
            val memes = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images = memes?.url ?: emptyList<>()
                    lista.clear()
                    lista.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                        //Toast.makeText(this, 7, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
