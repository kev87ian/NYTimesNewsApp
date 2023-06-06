package com.kev.nytimes.data.remote.dto.latestnews


import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("byline")
    val author: String,
    @SerializedName("multimedia")
    val multimediaDTO: List<MultimediaDTO>?,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_date")
    val updatedDate: String,
    @SerializedName("url")
    val url: String
)