package com.example.memeapi.response

import com.google.gson.annotations.SerializedName

data class MemeResponse(
    @SerializedName("idMeme") var id: Int,
    @SerializedName("nombre") var nombre: String,
    @SerializedName("url") var url: String,
    @SerializedName("tSuperior") var titSup: String,
    @SerializedName("tInferior") var titInf: String
)
