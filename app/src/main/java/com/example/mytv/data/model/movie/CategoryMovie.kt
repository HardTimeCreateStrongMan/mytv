package com.example.mytv.data.model.movie

import com.google.gson.annotations.SerializedName

data class CategoryMovie(
    @SerializedName("CATE_ID")
    val cateMID: String,
    @SerializedName("CATE_NAME")
    val cateMName: String,
    @SerializedName("DATA")
    val movieList: List<movie>
)
