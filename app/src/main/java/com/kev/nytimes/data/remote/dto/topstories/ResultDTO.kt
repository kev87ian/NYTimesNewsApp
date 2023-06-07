package com.kev.nytimes.data.remote.dto.topstories

import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.topstories.Result

data class ResultDTO(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("multimedia")
    val multimediaDTO: List<MultimediaDTO>?,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("source")
    val source: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("section")
    val section: String?,
    @SerializedName("updated_date")
    val updatedDate: String,
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("url")
    val url: String
) {
    fun toDomainResult(): Result {
        return Result(
            abstract = abstract,

            multimedia = multimediaDTO?.map { it.toDomainMultiMedia() },
            publishedDate = publishedDate,
            source = source,
            title = title,
            updatedDate = updatedDate,
            url = url,
            section = section,
            byline = byline
        )
    }
}
