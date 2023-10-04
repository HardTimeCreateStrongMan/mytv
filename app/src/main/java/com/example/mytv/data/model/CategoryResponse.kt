package com.example.mytv.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    val result: String,
    @SerializedName("data")
    val categories: List<Category>
)
