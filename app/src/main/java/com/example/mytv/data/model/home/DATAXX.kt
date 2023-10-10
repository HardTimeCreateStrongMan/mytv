package com.example.mytv.data.model.home

import com.google.gson.annotations.SerializedName

data class DATAXX(
    @SerializedName("CHANNEL_ID") val channelId : String,
    @SerializedName("CONTENT_AGE") val contentAge : String,
    @SerializedName("CONTENT_ID") val contentID : String,
    @SerializedName("CONTENT_IMAGE_URL") val imgSrc : String,
    @SerializedName("TYPE_GROUP") val typeGroup : String,
    @SerializedName("TYPE_ID") val typeID : String,

)