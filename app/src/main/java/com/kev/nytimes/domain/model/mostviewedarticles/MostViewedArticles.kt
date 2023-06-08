package com.kev.nytimes.domain.model.mostviewedarticles


import com.google.gson.annotations.SerializedName

data class MostViewedArticles(
    val copyright: String,
    val numResults: Int,
    val mostViewedResults: List<MostViewedResult>,
    val status: String
)