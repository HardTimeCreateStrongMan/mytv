package com.example.mytv.data.model.film

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("CATE_ID") val cateID: String,
    @SerializedName("CATE_NAME") val cateName: String,
    @SerializedName("DATA") val movies: List<DATAX>,
)