package com.kev.nytimes.data.remote.dto.searcharticles


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searcharticles.SearchMultimedia

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
){
    fun toDomainMultimedia(): SearchMultimedia{
        return SearchMultimedia(
            caption = caption,
            credit = credit,
            cropName = cropName,
            height = height,
            legacy =  legacyDTO?.toDomainLegacy(),
            rank = rank,
            type = type,
            url = url,
            width = width,
            subtype = subtype
        )
    }
}