package com.example.project.model


import com.example.project.model.Tv
import com.google.gson.annotations.SerializedName

data class  TvList(
    //@SerializedName("page")
    //val page: Int,
    @SerializedName("results")
    val tvs: List<Tv>
    //@SerializedName("total_pages")
    //val totalPages: Int,
    //@SerializedName("total_results")
    //val totalResults: Int
)