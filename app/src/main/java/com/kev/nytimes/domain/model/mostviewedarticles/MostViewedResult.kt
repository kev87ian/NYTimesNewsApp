package com.kev.nytimes.domain.model.mostviewedarticles


import com.google.gson.annotations.SerializedName

data class MostViewedResult(
    val `abstract`: String,
    val byline: String,
    val id: Long,
    val media: List<Media>,
    val publishedDate: String,
    val title: String,
    val updated: String,
    val uri: String,
    val url: String
)