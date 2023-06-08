package com.kev.nytimes.domain.model.searcharticles


data class SearchMultimedia(
    val caption: Any?,
    val credit: Any?,
    val cropName: String,
    val height: Int,
    val legacy: Legacy?,
    val rank: Int,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
)