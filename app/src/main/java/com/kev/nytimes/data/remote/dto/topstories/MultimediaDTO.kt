package com.kev.nytimes.data.remote.dto.topstories


import com.google.gson.annotations.SerializedName

data class MultimediaDTO(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)