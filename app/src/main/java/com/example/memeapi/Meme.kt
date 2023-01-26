package com.example.memeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityMemeBinding

class Meme : AppCompatActivity() {
    private  var binding: ActivityMemeBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMemeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


    }
}