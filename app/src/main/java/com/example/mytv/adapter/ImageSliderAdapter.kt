package com.example.mytv.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.mytv.R
import com.example.mytv.data.model.Channel
import com.example.mytv.data.model.home.DataXXX
import com.example.mytv.data.model.home.Service

class ImageSliderAdapter(private var trailers: List<DataXXX>) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {
    private lateinit var onItemClick: OnItemCategoryClicked

    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivHome: ImageView = itemView.findViewById(R.id.test_image)
    }
    @SuppressLint("NotifyDataSetChanged")

    fun onItemClicked(onItemClick: OnItemCategoryClicked){
        this.onItemClick = onItemClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.testing, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(trailers[position].imgSrc)
            .into(holder.ivHome)    }


    override fun getItemCount(): Int {
        return trailers.size
    }

//    fun submitList(channels: List<Channel>?) {
//        this.channels = channels as List<Channel>
//        notifyDataSetChanged()
//    }

    interface OnItemCategoryClicked{
        fun onClickListener(channel: Channel)
    }

    interface OnLongCategoryClick{
        fun onCategoryLongCLick(channel: Channel)
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Channel> () {
            override fun areItemsTheSame (oldItem: Channel, newItem: Channel): Boolean {
                return oldItem.contentId == newItem.contentId }
            override fun areContentsTheSame (oldItem: Channel, newItem: Channel): Boolean {
                return oldItem == newItem }
        }
    }
}