package com.example.mytv.data.model.home

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "HomeService")
data class Service(
    @SerializedName("module_id") val test : String,
    @SerializedName("title") val title : String,
    @SerializedName("type_id") val typeID : String,

)