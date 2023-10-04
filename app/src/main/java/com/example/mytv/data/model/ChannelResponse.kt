package com.example.mytv.data.model

import com.google.gson.annotations.SerializedName

data class ChannelResponse(
    val result: String,
    @SerializedName("data")
    val channels: List<Channel>
)
