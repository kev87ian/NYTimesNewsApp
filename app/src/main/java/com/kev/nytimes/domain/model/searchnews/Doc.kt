package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class Doc(
    val abstract: String,
    val byline: Byline,
    val documentType: String,
    val id: String,
    val leadParagraph: String,
    val searchMultimedia: List<SearchMultimedia>,
    val pubDate: String,
    val snippet: String,
    val uri: String,
    val webUrl: String,

    )