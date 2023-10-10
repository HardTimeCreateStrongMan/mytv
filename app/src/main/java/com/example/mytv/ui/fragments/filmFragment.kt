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
import com.example.mytv.R
import com.example.mytv.databinding.FragmentFilmBinding

import com.example.mytv.ViewModel.FilmViewModel
import com.example.mytv.adapter.ChannelAdapter
import com.example.mytv.data.model.Category
import com.example.mytv.data.model.Channel
import com.google.android.material.tabs.TabLayout

class filmFragment : Fragment() {
    private lateinit var binding:FragmentFilmBinding
    private lateinit var filmMVVM: FilmViewModel
    private lateinit var  tlChannelCategories: TabLayout
    private lateinit var rvChannel: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filmMVVM = ViewModelProviders.of(this)[FilmViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_film, container, false)
        this.rvChannel = view.findViewById(R.id.channel_display)
        this.rvChannel.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        this.rvChannel.setHasFixedSize(true)
        prepareRecyclerView()
        setID(view)
        setData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()

    }

//    private fun observeCategories() {
//        filmMVVM.observeCategories().observe(viewLifecycleOwner, Observer { categories ->
//            categories.forEach { category ->
//                Log.d("test", category.cateName)
//            }
//        })
//        }
    private fun setID(view: View){
         tlChannelCategories = view.findViewById(R.id.channelCategories)
    }

    private fun setData() {
        filmMVVM.categories.observe(viewLifecycleOwner) {
            this.tlChannelCategories.removeAllTabs()
            for (category in it) {
                val tabChannelCategory: TabLayout.Tab = tlChannelCategories.newTab()
                tabChannelCategory.text = category.cateName
                tlChannelCategories.addTab(tabChannelCategory)
            }
        }
    }
    private fun prepareRecyclerView(){
        filmMVVM.channels.observe(viewLifecycleOwner){
            val channels = it
            val channelAdapter = ChannelAdapter(channels)
            rvChannel.adapter = channelAdapter
//            channelAdapter.submitList(it)

        }
    }



//   private fun observeCategories() {
//       filmMVVM.observeCategories().observe(viewLifecycleOwner, object : Observer<List<Category>> {
//           override fun onChanged(t: List<Category>?) {
//               myAdapter.setCategoryList(t!!)
//           }
//       })
//   }
    }