package com.kev.nytimes.domain.model.mostviewedarticles


data class MostViewedResult(
    val `abstract`: String,
    val byline: String,
    val id: Long,
    val media: List<Media>,
    val publishedDate: String,
    val title: String,
    val section: String,
    val updated: String,
    val uri: String,
    val url: String
)