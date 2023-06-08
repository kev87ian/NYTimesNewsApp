package com.kev.nytimes.domain.model.topstories

data class TopStories(
    val numResults: Int,
    val results: List<Result>,
    val status: String
)
