package com.kev.nytimes.domain.model.topstories


import com.google.gson.annotations.SerializedName

data class Result(
    val abstract: String,
    val author: String,
    val multimedia: List<Multimedia>?,
    val publishedDate: String,
    val source: String,
    val title: String,
    val updatedDate: String,
    val url: String
)