package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.memeapi.databinding.ActivityObtenerMemeBinding

class ObtenerMeme : AppCompatActivity() {

    private lateinit var binding: ActivityObtenerMemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityObtenerMemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun siguiente(view:View){
        intent= Intent(this, Meme::class.java).apply {
            putExtra("idMeme", binding.idMeme.text.toString())
        }
        startActivity(intent)
    }


}