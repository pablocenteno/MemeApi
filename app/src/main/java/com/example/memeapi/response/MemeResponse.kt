package com.example.memeapi.response

import com.google.gson.annotations.SerializedName

data class MemeResponse(
    @SerializedName("idMeme") var id: Int,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("url") var url: String,
    @SerializedName("titSup") var titSup: String,
    @SerializedName("titInf") var titInf: String
)
