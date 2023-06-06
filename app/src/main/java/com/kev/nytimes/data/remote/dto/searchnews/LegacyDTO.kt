package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searchnews.Legacy

data class LegacyDTO(
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("thumbnailheight")
    val thumbnailheight: Int?,
    @SerializedName("thumbnailwidth")
    val thumbnailwidth: Int?,
    @SerializedName("wide")
    val wide: String?,
    @SerializedName("wideheight")
    val wideheight: Int?,
    @SerializedName("widewidth")
    val widewidth: Int?,
    @SerializedName("xlarge")
    val xlarge: String?,
    @SerializedName("xlargeheight")
    val xlargeheight: Int?,
    @SerializedName("xlargewidth")
    val xlargewidth: Int?
){
    fun toDomainLegacy(): Legacy{
        return Legacy(
            thumbnail = thumbnail,
            thumbnailheight = thumbnailheight,
            thumbnailwidth  = thumbnailwidth,
            wide = wide,
            wideheight = wideheight,
            widewidth = widewidth,
            xlarge = xlarge,
            xlargeheight = xlargeheight,
            xlargewidth = xlargewidth
        )
    }
}