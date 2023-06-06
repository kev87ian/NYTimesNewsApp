package com.kev.nytimes.data.remote.dto.topstories


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.topstories.TopStories

data class TopStoriesDTO(
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val resultDTOS: List<ResultDTO>,
    @SerializedName("status")
    val status: String
){

    fun toDomainTopStories(): TopStories{
        return TopStories(
            numResults = numResults,
            results = resultDTOS.map { it.toDomainResult() },
            status = status
        )
    }
}