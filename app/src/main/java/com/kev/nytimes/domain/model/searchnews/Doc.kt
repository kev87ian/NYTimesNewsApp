package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class Doc(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("byline")
    val byline: Byline,
    @SerializedName("document_type")
    val documentType: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    @SerializedName("multimedia")
    val searchMultimedia: List<SearchMultimedia>,
    @SerializedName("pub_date")
    val pubDate: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("web_url")
    val webUrl: String,

    )