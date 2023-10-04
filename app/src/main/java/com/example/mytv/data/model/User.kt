package com.example.mytv.data.model
import com.google.gson.annotations.SerializedName;

data class User(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("device_model") val deviceModel: String,
    @SerializedName("fk") val fk: String,
    @SerializedName("device_type") val deviceType: Int,
    @SerializedName("version_number") val versionNumber: Int,
    @SerializedName("authen_type") val authenType: Int,
    @SerializedName("manufacturer_id") val manufacturerId: String,
    @SerializedName("device_manu") val deviceManu: String,
    @SerializedName("app_hash") val appHash: String
)
