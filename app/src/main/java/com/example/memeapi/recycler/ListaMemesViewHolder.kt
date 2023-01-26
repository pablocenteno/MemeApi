package com.example.memeapi.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memeapi.R
import com.example.memeapi.databinding.ItemMemeBinding
import com.example.memeapi.response.MemeResponse
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class ListaMemesViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private var tvSup = itemView.findViewById<TextView>(R.id.tit_sup)
    private var tvInf = itemView.findViewById<TextView>(R.id.tit_inf)

    private val binding= ItemMemeBinding.bind(view)

    fun render(response: MemeResponse){
        tvSup.text=response.titSup
        tvInf.text=response.titInf
        Picasso.get().load(response.url).into(binding.foto)
    }

}