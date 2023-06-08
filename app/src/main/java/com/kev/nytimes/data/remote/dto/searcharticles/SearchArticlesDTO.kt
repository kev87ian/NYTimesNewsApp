package com.kev.nytimes.data.remote.dto.searcharticles


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searcharticles.SearchArticles

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