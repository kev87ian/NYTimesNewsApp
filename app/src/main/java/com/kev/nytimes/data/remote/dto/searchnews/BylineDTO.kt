package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName

data class BylineDTO(
    @SerializedName("organization")
    val organization: String?,
    @SerializedName("original")
    val original: String?,

)