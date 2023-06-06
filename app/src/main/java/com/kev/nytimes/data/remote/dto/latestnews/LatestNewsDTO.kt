package com.kev.nytimes.data.remote.dto.latestnews


import com.google.gson.annotations.SerializedName

data class LatestNewsDTO(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val resultDTOS: List<ResultDTO>,
    @SerializedName("status")
    val status: String
)