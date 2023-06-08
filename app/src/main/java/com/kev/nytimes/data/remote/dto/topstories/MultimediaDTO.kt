package com.kev.nytimes.data.remote.dto.topstories


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.topstories.Multimedia

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
){
    fun toDomainMultiMedia(): Multimedia{
        return Multimedia(
            caption = caption,
            copyright = copyright,
            format = format,
            height= height,
            subtype = subtype,
            type= type,
            url = url,
            width
        )
    }

}