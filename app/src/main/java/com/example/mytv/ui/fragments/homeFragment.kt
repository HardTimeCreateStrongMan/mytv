package com.example.mytv.ui.fragments

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mytv.R
import com.example.mytv.databinding.FragmentFilmBinding

import com.example.mytv.ViewModel.FilmViewModel
import com.example.mytv.ViewModel.HomeViewModel
import com.example.mytv.adapter.ChannelAdapter
import com.example.mytv.adapter.HomeAdapter
import com.example.mytv.adapter.ImageSliderAdapter
import com.example.mytv.data.model.Category
import com.example.mytv.data.model.Channel
import com.example.mytv.data.model.home.Service
import com.google.android.material.tabs.TabLayout

class homeFragment : Fragment() {
    private lateinit var homeMVVM: HomeViewModel
    private lateinit var tlChannelCategories: TabLayout
    private lateinit var rvChannel: RecyclerView
    private lateinit var tvHome: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMVVM = ViewModelProviders.of(this)[HomeViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setID(view)
        setData()
        SetImageList(view)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //    private fun observeCategories() {
//        filmMVVM.observeCategories().observe(viewLifecycleOwner, Observer { categories ->
//            categories.forEach { category ->
//                Log.d("test", category.cateName)
//            }
//        })
//        }
    private fun setID(view: View) {
        tvHome = view.findViewById(R.id.CategoryName)
       // rvChannel = view.findViewById(R.id.testImage)
        //val imageSlider = view.findViewById<ImageSlider>(R.id.imageTest)
    }
    private fun setData(){
        homeMVVM.services.observe(viewLifecycleOwner){
            val services = it
            val homeAdapter = HomeAdapter(services.data.services)
            tvHome.adapter = homeAdapter
            tvHome.layoutManager = GridLayoutManager(this.context, 1)
        }
//            val imageAdapter = ImageSliderAdapter(services.data.trailers.trailers)
//
//            rvChannel.adapter = imageAdapter
//            rvChannel.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
//            this.rvChannel.setHasFixedSize(true)
        }
    private fun SetImageList(view: View) {
        homeMVVM.services.observe(viewLifecycleOwner) {
            val imageList = ArrayList<SlideModel>()
            val services = it
            for (trailer in it.data.trailers.trailers) {
                imageList.add(SlideModel(trailer.imgSrc))
            }
            val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
            imageSlider.setImageList(imageList)
        }
    }
    }
