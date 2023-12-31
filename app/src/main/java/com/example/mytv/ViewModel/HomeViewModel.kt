package com.example.mytv.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytv.data.api.CategoryApi
import com.example.mytv.data.model.home.ServiceTotal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
//    var Services = MutableLiveData<ServiceResponse>()
    val status: LiveData<String> = _status
    val services = MutableLiveData<ServiceTotal>()
    init {
        getServicesName()
    }
    private fun getServicesName() {
        val params = HashMap<String, String>()
        params["device_model"] = "sdk_google_atv64_amati_arm64"
        params["fk"] = "first#key"
        params["session"] = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjE0LjIyNS4xMS4xMzAiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODQ5MDAzMjU5LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.LBbCBK-BB54EwbngOk4D-R0ANNlyuhyundAvy5vKh8M"
        params["device_type"] = "9"
        params["version_number"] = "470"
        params["username_mytv"] = "tsna90"
        params["product_id"] = "57"
        params["member_id"] = "828593"
        params["manufacturer_id"] = "7046fc86f010cba1"
        params["device_manu"] = "Google"
        params["profile_type"] = "1"
        params["area_code"] = "HNI"
        params["user_team_id"] = "235"
        params["check_session"] = "1"
        params["ver_menu"] = "5"
        params["profile_id"] = "828593"
        params["username"] = "tsna90"
        params["ver_app_show"] = "14"
        //ShareReference
        CategoryApi.apiService.getCategoryHomeName(params)
            .enqueue(object : Callback<ServiceTotal> {
                override fun onResponse(
                    call: Call<ServiceTotal>,
                    response: Response<ServiceTotal>
                ) {
//                if (response.isSuccessful){
//                    response.body()?.let{
//                        Log.i("Response", "onResponse: ${response.body()}")
//                    }
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Log.i("testlan3", "onResponse: ${response.body()}")
                        }
                            services.postValue(response.body())
                    }
                }
                    override fun onFailure(call: Call<ServiceTotal>, t: Throwable) {
                        Log.d("testlan3", "may sai roi")
                    }
            })
    }
//    fun getContentByID(trailer: DataXXX): Boolean {
//        for(service in categories){
//            if (trailer.typeID == service.typeID){
//                return true
//            }
//        }
//        return false
//    }
//    val matchedTrailers = trailers.filter { getContentByID(it) }

}
