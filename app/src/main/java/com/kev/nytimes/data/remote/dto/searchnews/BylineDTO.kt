package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searchnews.Byline

data class BylineDTO(
    @SerializedName("organization")
    val organization: String?,
    @SerializedName("original")
    val original: String?,
){
    fun toDomainByline(): Byline{
        return Byline(
            organization = organization,
            original = original
        )
    }
}