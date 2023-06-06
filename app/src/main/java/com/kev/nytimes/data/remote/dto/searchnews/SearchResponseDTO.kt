package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName

data class SearchResponseDTO(
    @SerializedName("docs")
    val docDTOS: List<DocDTO>,
    @SerializedName("meta")
    val meta: Meta
)