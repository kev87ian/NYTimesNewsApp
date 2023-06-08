package com.kev.nytimes.domain.model.mostviewedarticles


import com.google.gson.annotations.SerializedName

data class MediaMetadata(
    val format: String,
    val height: Int,
    val url: String,
    val width: Int
)