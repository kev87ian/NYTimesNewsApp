package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName

data class SearchNewsDTO(
    @SerializedName("response")
    val searchResponseDTO: SearchResponseDTO,
)