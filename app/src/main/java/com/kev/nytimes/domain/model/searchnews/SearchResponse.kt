package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val docs: List<Doc>

    )