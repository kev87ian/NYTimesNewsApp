package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

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