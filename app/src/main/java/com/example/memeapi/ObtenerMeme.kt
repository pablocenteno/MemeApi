package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ObtenerMeme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obtener_meme)


    }

    fun siguiente(view:View){
        intent= Intent(this, Meme::class.java)
        startActivity(intent)
    }

}