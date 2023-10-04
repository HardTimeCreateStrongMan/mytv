//package com.example.mytv.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mytv.R
//import com.example.mytv.data.model.Category
//
//class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
//private var categories:List<Category> = ArrayList()
//    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_film, parent, false)
//        return CategoryViewHolder(view)
//    }
//    fun setCategoryList(categories: List<Category>){
//        this.categories = categories
//        notifyDataSetChanged()
//    }
//
//
////    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
////        val category = categories[position]
////        holder.nameTextView.text = category.cateName
////    }
//
//    override fun getItemCount(): Int {
//        return categories.size
//    }
//}