package com.kev.nytimes.data.remote.dto.topstories


import com.google.gson.annotations.SerializedName

data class TopStoriesDTO(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val resultDTOS: List<ResultDTO>,
    @SerializedName("status")
    val status: String
)