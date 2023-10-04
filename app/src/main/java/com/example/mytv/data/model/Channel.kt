package com.example.mytv.data.model

import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName ("CONTENT_ID") val contentId: String,
    @SerializedName ("CONTENT_TITLE") val title: String,
    @SerializedName ("CONTENT_IMAGE_URL") val imgSrc: String
)
