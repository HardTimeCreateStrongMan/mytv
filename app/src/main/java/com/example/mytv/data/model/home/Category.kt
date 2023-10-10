package com.example.mytv.data.model.home

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("CATE_ID") val cateID : String,
    @SerializedName("CATE_NAME") val cateName : String,
    @SerializedName("DATA") val data: List<DATAX>,
    @SerializedName("TYPE_ID") val typeID : String,
    //category
)