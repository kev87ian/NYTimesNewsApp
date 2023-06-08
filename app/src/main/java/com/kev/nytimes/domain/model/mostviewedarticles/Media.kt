package com.kev.nytimes.domain.model.mostviewedarticles


import com.google.gson.annotations.SerializedName

data class Media(
    val approvedForSyndication: Int,
    val caption: String,
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)