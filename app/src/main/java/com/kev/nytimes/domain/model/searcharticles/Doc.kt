package com.kev.nytimes.domain.model.searcharticles


data class Doc(
    val abstract: String,
    val byline: Byline,
    val documentType: String,
    val id: String,
    val leadParagraph: String,
    val sectionName: String,
    val searchMultimedia: List<SearchMultimedia>,
    val pubDate: String,
    val snippet: String,
    val uri: String,
    val webUrl: String,

    )