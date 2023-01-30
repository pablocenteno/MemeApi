package com.example.memeapi.response

import com.google.gson.annotations.SerializedName

data class TagResponse(
    @SerializedName("idTag") var id: Int,
    @SerializedName("texto") var texto:String
)
