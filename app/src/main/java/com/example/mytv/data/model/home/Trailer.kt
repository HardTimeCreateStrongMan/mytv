package com.example.mytv.data.model.home

import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("type_change")
    val typeTest: String,
    @SerializedName("data")
    val trailers: List<DataXXX>
)
