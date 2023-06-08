package com.kev.nytimes.data.remote.dto.mostviewed


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.mostviewedarticles.MediaMetadata

data class MediaMetadataDTO(
    @SerializedName("format")
    val format: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
){
    fun toDomainMediaMetaData(): MediaMetadata{
        return MediaMetadata(
            format = format,
            height = height,
            url = url,
            width = width
        )
    }
}