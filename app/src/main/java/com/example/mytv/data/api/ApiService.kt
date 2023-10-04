package com.example.mytv.data.api

import com.example.mytv.data.model.CategoryResponse
import com.example.mytv.data.model.ChannelResponse
import retrofit2.http.Body
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .baseUrl("https://b2cstage2.mytv.vn/v8/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()


object CategoryApi{
    val apiService: ApiService by lazy {retrofit.create(ApiService::class.java) }
}

interface ApiService {

    // Define the content type header
    companion object {
        const val CONTENT_TYPE = "Content-Type: application/x-www-form-urlencoded"
    }

    // Define the authen-v7 endpoint
    @Headers(CONTENT_TYPE)
    @POST("authen-v7")
    suspend fun authen()

    @Headers(CONTENT_TYPE)
    @POST("get-config-v4")
    suspend fun getContent()

    @Headers(CONTENT_TYPE)
    @POST("home-page1-v2")
    suspend fun test()

    @Headers(CONTENT_TYPE)
    @POST("channel/category-v2")
    fun getCategory(@Body payload: String): Call<CategoryResponse>

    @Headers(CONTENT_TYPE)
    @POST("channel/list-v3")
    fun getChannel(@Body payload: String): Call<ChannelResponse>

    @Headers(CONTENT_TYPE)
    @POST("content/home")
    suspend fun test4()

    @Headers(CONTENT_TYPE)
    @POST("account/info-v5")
    suspend fun test5()
}