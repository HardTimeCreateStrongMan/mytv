package com.example.mytv.data.model.home

import com.example.mytv.data.model.Category
import com.google.gson.annotations.SerializedName

data class ServiceTotal(
    val result: String,

    @SerializedName("data")
    val data: ServiceResponse
)
