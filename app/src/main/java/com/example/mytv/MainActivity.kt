package com.example.mytv

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.denzcoskun.imageslider.ImageSlider
import com.example.mytv.databinding.ActivityMainBinding
import com.example.mytv.databinding.SigninBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = Navigation.findNavController(this, R.id.frag_host)

        NavigationUI.setupWithNavController(bottomNavigation, navController)

        //val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
    }

}