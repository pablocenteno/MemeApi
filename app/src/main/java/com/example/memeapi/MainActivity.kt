package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun listaMemes(view: View){
        intent = Intent(this, ListaMemes::class.java)
        startActivity(intent)
    }
    fun buscarMemePorId(view:View){
        intent = Intent(this, ObtenerMeme::class.java)
        startActivity(intent)
    }

    fun crearMeme(view:View){
        intent=Intent(this,CrearMeme::class.java)
        startActivity(intent)
    }

    fun creoTag(view: View){
        intent=Intent(this,CrearTag::class.java)
        startActivity(intent)
    }
}