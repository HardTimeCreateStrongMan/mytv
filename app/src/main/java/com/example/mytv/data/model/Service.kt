package com.example.mytv.data.model

import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("api_url") val link: String,
    @SerializedName("cate_id") val cateid: Any,
    val id: String,
    val keyword: String,
    val logo: String,
    @SerializedName("poster_layout") val posterlayout: String,
    @SerializedName("screen_name")   val screenName: String,
    val title: String,
    val url: String
)