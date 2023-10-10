package com.example.mytv.data.model.film

import com.google.gson.annotations.SerializedName

data class DATAX(
    @SerializedName("CHANNEL_ID") val channelID: String,
    @SerializedName("CONTENT_AGE") val age: String,
    @SerializedName("CONTENT_CATEGORY_NAME") val categoryName: String,
    @SerializedName("CONTENT_COUNTRY") val country: String,
    @SerializedName("CONTENT_DESC") val desc: String,
    @SerializedName("CONTENT_IMAGE_URL") val imgSrc: String,
    @SerializedName("CONTENT_TITLE") val title: String,
    @SerializedName("CONTENT_NAME_EN") val contentName: String,
    @SerializedName("TOTAL_EPISODE") val totalEp: String
)