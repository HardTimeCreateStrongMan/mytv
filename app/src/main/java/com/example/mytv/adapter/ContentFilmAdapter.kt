package com.example.mytv.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytv.R
import com.example.mytv.data.model.film.Data

class ContentCategoryAdapter(private val contentCategories: List<Data>)
    : RecyclerView.Adapter<ContentCategoryAdapter.ContentViewHolder>() {

    inner class ContentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvContentTitle: TextView = itemView.findViewById(R.id.ivContentTitle)
        val rvDetailedContentCategory: RecyclerView = itemView.findViewById(R.id.rvDetailedContentCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_content, parent, false)
        val rvDetailedContentCategory: RecyclerView = view.findViewById(R.id.rvDetailedContentCategory)
        rvDetailedContentCategory.adapter = SubContentAdapter()
        return ContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentCategories.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val contentCategory = contentCategories[position]

        contentCategory.cateName.also { holder.tvContentTitle.text = it }
        contentCategory.movies.also {
            val adapter = holder.rvDetailedContentCategory.adapter as SubContentAdapter
            adapter.submitList(contentCategory.movies)
        }
    }
}