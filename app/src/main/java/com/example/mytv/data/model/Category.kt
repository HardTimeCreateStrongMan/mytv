package com.example.mytv.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("CATE_ID")
    val cateId: String,
    @SerializedName("CATE_NAME")
    val cateName: String,
    @SerializedName("LIST_ID")
    val listID: String,
)