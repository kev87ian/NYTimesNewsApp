package com.kev.nytimes.data.remote.dto.mostviewed


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.mostviewedarticles.Media

data class MediaDTO(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("media-metadata")
    val mediaMetadataDTOS: List<MediaMetadataDTO>,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("type")
    val type: String
){
    fun toDomainMedia(): Media {
        return Media(
            approvedForSyndication = approvedForSyndication,
            caption = caption,
            mediaMetadata = mediaMetadataDTOS.map { it.toDomainMediaMetaData() },
            subtype = subtype,
            type = type
        )
    }
}