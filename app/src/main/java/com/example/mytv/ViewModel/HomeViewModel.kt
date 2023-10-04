package com.example.mytv.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytv.data.api.CategoryApi
import com.example.mytv.data.model.Category
import com.example.mytv.data.model.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    var categories = MutableLiveData<List<Category>>()
    val status: LiveData<String> = _status
    init{
        getCategory()
    }

    fun getCategory(){
        CategoryApi.apiService.getCategory("device_model=sdk_google_atv64_amati_arm64&fk=first%23key&session=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjE0LjIyNS4xMS4xMzAiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODQ5MDAzMjU5LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.LBbCBK-BB54EwbngOk4D-R0ANNlyuhyundAvy5vKh8M&device_type=9&version_number=470&username_mytv=tsna90&product_id=57&member_id=828593&manufacturer_id=7046fc86f010cba1&device_manu=Google&profile_type=1&area_code=HNI&user_team_id=235&check_session=1&ver_menu=5&profile_id=828593&username=tsna90").enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
//                if (response.isSuccessful){
//                    response.body()?.let{
//                        Log.i("Response", "onResponse: ${response.body()}")
//                    }
                response.body()?.let { categoryResponse ->
                    categories.postValue(categoryResponse.categories)
                }
                if (response.body() != null) {
                    categories.value = response.body()!!.categories
                }
            }
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("FilmFragment", t.message.toString())
            }
        })
    }
    fun observeCategories():LiveData<List<Category>>{
        return categories
    }
    }
