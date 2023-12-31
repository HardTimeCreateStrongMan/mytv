package com.example.mytv.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytv.R
import com.example.mytv.data.model.Category
import com.example.mytv.data.model.Channel
import com.example.mytv.databinding.FragmentFilmBinding
import com.example.mytv.databinding.ItemChannelBinding

class ChannelAdapter(private var channels: List<Channel>) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {
    private lateinit var onItemClick: OnItemCategoryClicked

    inner class ChannelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivChannelItem: ImageView = itemView.findViewById(R.id.testing)
    }
    @SuppressLint("NotifyDataSetChanged")

    fun onItemClicked(onItemClick: OnItemCategoryClicked){
        this.onItemClick = onItemClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
            Glide.with(holder.itemView)
                .load(channels[position].imgSrc)
                .into(holder.ivChannelItem)
        }


    override fun getItemCount(): Int {
        return channels.size
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