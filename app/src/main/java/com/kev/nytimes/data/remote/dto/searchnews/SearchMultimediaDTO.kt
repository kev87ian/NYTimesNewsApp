package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName

data class SearchMultimediaDTO(
    @SerializedName("caption")
    val caption: Any?,
    @SerializedName("credit")
    val credit: Any?,
    @SerializedName("crop_name")
    val cropName: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("legacy")
    val legacyDTO: LegacyDTO?,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("subType")
    val subType: String,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)