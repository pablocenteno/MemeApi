package com.example.memeapi.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memeapi.R
import com.example.memeapi.response.MemeResponse


class ListaMemesAdapter(private var memes:MutableList<MemeResponse>) :
    RecyclerView.Adapter<ListaMemesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaMemesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaMemesViewHolder(layoutInflater.inflate(R.layout.item_meme,parent,false))
    }

    override fun onBindViewHolder(holder: ListaMemesViewHolder, position: Int) {
        holder.render(memes[position])
    }

    override fun getItemCount(): Int {
        return memes.size
    }
}