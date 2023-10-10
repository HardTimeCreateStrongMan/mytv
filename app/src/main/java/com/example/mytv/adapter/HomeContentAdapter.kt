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
import com.example.mytv.data.model.Category
import com.example.mytv.data.model.Channel
import com.example.mytv.data.model.home.DataXXX
import com.example.mytv.data.model.home.ServiceResponse
import com.example.mytv.databinding.FragmentFilmBinding
import com.example.mytv.databinding.ItemChannelBinding

class HomeContentAdapter (private val trailers: List<DataXXX>) : RecyclerView.Adapter<HomeContentAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivSubContentCategory: ImageView = itemView.findViewById(R.id.ivSubContentCategory)
        val tvSubContentCategory: TextView = itemView.findViewById(R.id.tvSubContentCategory)
    }
    @SuppressLint("NotifyDataSetChanged")

    fun onItemClicked(onItemClick: OnItemCategoryClicked){
        //this.onItemClick = onItemClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.moviereplay, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        Glide.with(holder.itemView)
            .load(trailers[position].imgSrc)
            .into(holder.ivSubContentCategory)
    }


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