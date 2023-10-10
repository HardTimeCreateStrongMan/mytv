package com.example.mytv.data.model.home

import com.google.gson.annotations.SerializedName

data class Row2(

    @SerializedName("CATE_ID") val cateID : String,
    @SerializedName("CATE_NAME") val cateName : String,
    @SerializedName("DATA") val data: List<DATAXX>,
    @SerializedName("TYPE_ID") val typeID : String,
    //kenh ca nhan
)