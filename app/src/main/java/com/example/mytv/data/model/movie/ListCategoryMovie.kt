package com.example.mytv.data.model.movie

import com.google.gson.annotations.SerializedName

data class ListCategoryMovie(
    @SerializedName ("data")
    val categoryMovieList: List<CategoryMovie>,
    @SerializedName ("result")
    val result: String,
)
