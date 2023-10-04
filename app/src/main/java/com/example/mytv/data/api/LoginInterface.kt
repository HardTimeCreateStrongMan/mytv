package com.example.mytv.data.api
import com.example.mytv.data.model.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import com.example.mytv.data.model.User
import retrofit2.http.Header
import retrofit2.http.Query

interface LoginInterface {
    @POST("login")
    suspend fun login(@Body credentials: Credentials): Response<LoginResponse>
}

data class Credentials(val username: String, val password: String)

object RetrofitClient {
    private const val BASE_URL = "https://b2cstage2.mytv.vn/v8/"

    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: LoginInterface by lazy {
        retrofit.create(LoginInterface::class.java)
    }
}

interface AuthService {
    // The base URL of the web service
    companion object {
        const val BASE_URL = "https://b2cstage2.mytv.vn/v8/"
    }

    // The endpoint for authentication
    @POST("authen-v7")
    suspend fun authenticate(
        // The query parameters for authentication
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("device_model") deviceModel: String,
        @Query("fk") fk: String,
        @Query("device_type") deviceType: Int,
        @Query("version_number") versionNumber: Int,
        @Query("authen_type") authenType: Int,
        @Query("manufacturer_id") manufacturerId: String,
        @Query("device_manu") deviceManu: String,
        @Query("app_hash") appHash: String
    ): Response<User> // The response type is a User object
}