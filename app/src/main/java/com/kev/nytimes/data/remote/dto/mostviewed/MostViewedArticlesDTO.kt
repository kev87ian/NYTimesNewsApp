package com.kev.nytimes.data.remote.dto.mostviewed


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedArticles

data class MostViewedArticlesDTO(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val mostViewedResultDTOS: List<MostViewedResultDTO>,
    @SerializedName("status")
    val status: String
){
    fun toDomainMostViewedArticles(): MostViewedArticles{
        return MostViewedArticles(
            copyright = copyright,
            numResults = numResults,
            mostViewedResults = mostViewedResultDTOS.map { it.toDomainMostViewedResult() },
            status = status
        )
    }
}