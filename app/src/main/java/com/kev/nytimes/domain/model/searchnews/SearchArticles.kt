package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class SearchArticles(
    @SerializedName("response")
    val searchResponse: SearchResponse,
)