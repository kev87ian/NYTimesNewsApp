package com.kev.nytimes.data.remote.dto.searcharticles


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searcharticles.SearchResponse

data class SearchResponseDTO(
    @SerializedName("docs")
    val docDTOS: List<DocDTO>,
){
    fun toSearchResponse(): SearchResponse{
        return SearchResponse(
           docs = docDTOS.map { it.toDomainDoc() }
        )
    }
}