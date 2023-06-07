package com.kev.nytimes.domain.model.topstories


import com.google.gson.annotations.SerializedName

data class Result(
    val abstract: String,

    val multimedia: List<Multimedia>?,
    val publishedDate: String,
    val source: String?,
    val section: String?,
    val byline: String?,
    val title: String?,
    val updatedDate: String?,
    val url: String
)