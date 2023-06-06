package com.kev.nytimes.domain.model.searchnews


import com.google.gson.annotations.SerializedName

data class Byline(
    @SerializedName("organization")
    val organization: String?,
    @SerializedName("original")
    val original: String?,

)