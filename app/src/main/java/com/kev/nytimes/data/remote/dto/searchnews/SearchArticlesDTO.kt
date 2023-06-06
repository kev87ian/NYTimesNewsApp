package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searchnews.SearchArticles

data class SearchArticlesDTO(
    @SerializedName("response")
    val searchResponseDTO: SearchResponseDTO,
){
    fun toDomainSearchArticles(): SearchArticles{
        return SearchArticles(
          searchResponse = searchResponseDTO.toSearchResponse()
        )
    }
}