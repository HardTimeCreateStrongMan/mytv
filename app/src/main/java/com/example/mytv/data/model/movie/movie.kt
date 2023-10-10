package com.example.mytv.data.model.movie

import com.google.gson.annotations.SerializedName

data class movie(
    @SerializedName("CONTENT_ID")
    val contentID: String,
    @SerializedName("CONTENT_TITLE")
    val contentTitle: String,
    @SerializedName("CONTENT_NAME_EN")
    val contentEng: String,
    @SerializedName("CONTENT_IMAGE_URL")
    val imgSrc: String,
    @SerializedName("CONTENT_DESC")
    val desc: String
)
