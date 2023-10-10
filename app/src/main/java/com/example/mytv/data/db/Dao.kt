//package com.example.mytv.data.db
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import androidx.room.Dao
//import com.example.mytv.data.model.home.DataXXX
//import com.example.mytv.data.model.home.ServiceResponse
//@Dao
//interface Dao {
//    @Query("SELECT * FROM HomeService,HomeContent where HomeService.typeID = HomeContent.typeID & HomeService.typeID = :id")
//    fun getContentHomebyTypeID(id:String): DataXXX
//
//}