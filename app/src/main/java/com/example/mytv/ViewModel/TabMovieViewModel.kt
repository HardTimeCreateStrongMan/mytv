package com.example.mytv.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytv.data.api.CategoryApi
import com.example.mytv.data.model.film.phim
import com.example.mytv.data.model.home.ServiceTotal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TabMovieViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val films = MutableLiveData<phim>()
    init {
        getFilmName()
    }
    private fun getFilmName() {
        val params = HashMap<String, String>()
        params["device_model"] = "sdk_google_atv64_amati_arm64"
        params["fk"] = "first%23key"
        params["session"] = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjE0LjIyNS4xMS4xMzAiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODQ5MDAzMjU5LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.LBbCBK-BB54EwbngOk4D-R0ANNlyuhyundAvy5vKh8M"
        params["device_type"] = "9"
        params["language"] = "vi"
        params["version_number"] = "470"
        params["username_mytv"] = "tsna90"
        params["password"] = "c4ca4238a0b923820dcc509a6f75849b"
        params["user_type"] = "2"
        params["param_api"] = "module_service_id%3D2012"
        params["product_id"] = "57"
        params["member_id"] = "828593"
        params["ver"] = "0"
        params["manufacturer_id"] = "7046fc86f010cba1"
        params["device_manu"] = "Google"
        params["profile_type"] = "1"
        params["type_id"] = "2"
        params["area_code"] = "HNI"
        params["register_info_register_trial"] = "0"
        params["user_team_id"] = "235"
        params["check_session"] = "1"
        params["api_ver"] = "0"
        params["register_info_type_member"] = "0"
        params["module_id"] = "2012"
        params["username"] = "tsna90"
        //ShareReference
        CategoryApi.apiService.getTabMovie("device_model=sdk_google_atv64_amati_arm64&fk=first%23key&session=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjE0LjIyNS4xMS4xMzAiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODQ5MDAzMjU5LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.LBbCBK-BB54EwbngOk4D-R0ANNlyuhyundAvy5vKh8M&device_type=9&language=vi&version_number=470&username_mytv=tsna90&password=c4ca4238a0b923820dcc509a6f75849b&user_type=2&param_api=module_service_id%3D2012&product_id=57&member_id=828593&ver=0&manufacturer_id=7046fc86f010cba1&device_manu=Google&profile_type=1&type_id=2&area_code=HNI&register_info_register_trial=0&user_team_id=235&check_session=1&api_ver=0&register_info_type_member=0&module_id=2012&username=tsna90")
            .enqueue(object : Callback<phim> {
                override fun onResponse(
                    call: Call<phim>,
                    response: Response<phim>
                ) {
//                if (response.isSuccessful){
//                    response.body()?.let{
//                        Log.i("Response", "onResponse: ${response.body()}")
//                    }
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Log.i("testlan4", "onResponse: ${response.body()}")
                        }
                        films.postValue(response.body())
                    }
                }
                override fun onFailure(call: Call<phim>, t: Throwable) {
                    Log.d("testlan4", "may sai roi")
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
