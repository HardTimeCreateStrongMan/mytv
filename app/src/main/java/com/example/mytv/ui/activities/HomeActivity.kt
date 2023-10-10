package com.example.mytv

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
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

      //  val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
     //   val imageList = ArrayList<SlideModel>()

        //imageList.add(SlideModel())
        // imageSlider.setImageList(imageList, Scaletypes.FIT)
    }

}