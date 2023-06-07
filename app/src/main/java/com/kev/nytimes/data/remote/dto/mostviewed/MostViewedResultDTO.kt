package com.kev.nytimes.data.remote.dto.mostviewed


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult

data class MostViewedResultDTO(
    @SerializedName("abstract")
    val `abstract`: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("media")
    val mediaDTOS: List<MediaDTO>,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("url")
    val url: String
){
    fun toDomainMostViewedResult(): MostViewedResult{
        return MostViewedResult(
            abstract = abstract,
            byline = byline,
            id = id,
            media = mediaDTOS.map { it.toDomainMedia() },
            publishedDate = publishedDate,
            title = title,
            updated = updated,
            uri = uri,
            url = url
        )
    }
}
