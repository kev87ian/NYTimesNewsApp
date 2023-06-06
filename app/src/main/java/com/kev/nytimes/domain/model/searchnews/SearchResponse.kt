package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("docs")
    val docs: List<Doc>,

    )