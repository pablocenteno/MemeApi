package com.example.memeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapi.databinding.ActivityListaMemesBinding

class ListaMemes : AppCompatActivity() {
    private lateinit var binding:ActivityListaMemesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_memes)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recycler.layoutManager= LinearLayoutManager(this)

    }
}