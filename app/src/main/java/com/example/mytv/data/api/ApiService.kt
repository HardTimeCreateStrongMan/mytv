package com.example.mytv.data.api

import com.example.mytv.data.model.CategoryResponse
import com.example.mytv.data.model.ChannelResponse
import com.example.mytv.data.model.film.phim
import com.example.mytv.data.model.home.ServiceTotal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PartMap
import retrofit2.http.QueryMap


private val retrofit = Retrofit.Builder()
    .baseUrl("https://b2cstage2.mytv.vn/v8/")
    .client(OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build())
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
    @FormUrlEncoded
    @POST("home-page1-v2")
    fun getCategoryHomeName(@FieldMap params: HashMap<String, String>  ): Call<ServiceTotal>

    @Headers(CONTENT_TYPE)
    @POST("channel/category-v2")
    fun getCategory(@Body payload: String): Call<CategoryResponse>

    @Headers(CONTENT_TYPE)
    @POST("channel/list-v3")
    fun getChannel(@Body payload: String): Call<ChannelResponse>

    @Headers(CONTENT_TYPE)

    @POST("content/home")
//    fun getTabMovie(@FieldMap params: HashMap<String, String>  ): Call<phim>
    fun getTabMovie(@Body payload: String): Call<phim>
    @Headers(CONTENT_TYPE)
    @POST("account/info-v5")
    suspend fun test5()
}