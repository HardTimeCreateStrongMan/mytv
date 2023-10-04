package com.example.mytv.repository

import com.example.mytv.data.api.AuthService
import com.example.mytv.data.model.LoginResponse
import com.example.mytv.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
class UserRepository {
    // A singleton instance of the repository class
    companion object {
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserRepository().also { INSTANCE = it }
            }
        }
    }

    // A Retrofit instance with a Gson converter and a logging interceptor
    private val retrofit = Retrofit.Builder()
        .baseUrl(AuthService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build())
        .build()

    // A service instance created from the Retrofit instance
    private val authService = retrofit.create(AuthService::class.java)

    // A function that authenticates a user with the web service using coroutines
    suspend fun authenticate(user: User): User? {
        return withContext(Dispatchers.IO) { // Run in a background thread
            try {
                val response = authService.authenticate( // Make the network request
                    user.username,
                    user.password,
                    user.deviceModel,
                    user.fk,
                    user.deviceType,
                    user.versionNumber,
                    user.authenType,
                    user.manufacturerId,
                    user.deviceManu,
                    user.appHash
                )
                if (response.isSuccessful) { // Check if the response is successful
                    response.body() // Return the user object from the response body
                } else {
                    null // Return null if the response is not successful
                }
            } catch (e: Exception) {
                e.printStackTrace() // Handle any exceptions
                null // Return null if there is an exception
            }
        }
    }
}