package com.example.mytv

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mytv.databinding.ActivityMainBinding
import com.example.mytv.databinding.SigninBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = Navigation.findNavController(this, R.id.frag_host)

        NavigationUI.setupWithNavController(bottomNavigation, navController)

//        val imageSlider = findViewById<ImageSlider>(R.id.imageTest)
//        val imageList = ArrayList<SlideModel>()
//        imageList.add(SlideModel("https://bit.ly/2YoJ77H"))
    }

    fun startActivityMain(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}