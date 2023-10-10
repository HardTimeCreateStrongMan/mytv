package com.example.mytv.data.model.home

import androidx.room.Entity
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

@Entity(tableName = "")
data class ServiceResponse(
    @SerializedName("service")
    val services: List<Service>,
    @SerializedName("trailer")
    val trailers: Trailer,
//    @SerializedNJsonObject("row1")
//    val row1: List<com.example.mytv.data.model.home.Category>,
//    @SerializedName("row2")
//    val row2: List<Row2>

)
