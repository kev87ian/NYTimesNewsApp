package com.kev.nytimes.data.remote.dto.searchnews


import com.google.gson.annotations.SerializedName
import com.kev.nytimes.domain.model.searchnews.Doc

data class DocDTO(
    @SerializedName("abstract")
    val abstract: String,
    @SerializedName("byline")
    val bylineDTO: BylineDTO,
    @SerializedName("document_type")
    val documentType: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    @SerializedName("multimedia")
    val searchMultimediaDTO: List<SearchMultimediaDTO>,
    @SerializedName("pub_date")
    val pubDate: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("web_url")
    val webUrl: String,
){
    fun toDomainDoc(): Doc {
        return Doc(
            abstract = abstract,
            byline = bylineDTO.toDomainByline(),
            documentType = documentType,
            id = id,
            leadParagraph = leadParagraph,
            searchMultimedia = searchMultimediaDTO.map { it.toDomainMultimedia() },
            pubDate = pubDate,
            snippet = snippet,
            uri = uri,
            webUrl = webUrl
        )
    }
}