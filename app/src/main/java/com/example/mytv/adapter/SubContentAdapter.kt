package com.example.mytv.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytv.R
import com.example.mytv.data.model.film.DATAX

class SubContentAdapter constructor(
): ListAdapter<DATAX, SubContentAdapter.SubContentViewHolder>(object : DiffUtil.ItemCallback<DATAX>(){
    override fun areItemsTheSame(oldItem: DATAX, newItem: DATAX): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DATAX, newItem: DATAX): Boolean {
        return oldItem == newItem
    }

}) {
    inner class SubContentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivSubContentCategory: ImageView = itemView.findViewById(R.id.ivSubContentCategory)
        val tvSubContentCategory: TextView = itemView.findViewById(R.id.tvSubContentCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubContentViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_sub_content, parent, false)
        return SubContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubContentViewHolder, position: Int) {
        val content = getItem(position)


        content.title.also {
            holder.tvSubContentCategory.text = it
        }

        content.imgSrc.also {
            Glide.with(holder.itemView).load(it).into(holder.ivSubContentCategory)
        }
    }
}