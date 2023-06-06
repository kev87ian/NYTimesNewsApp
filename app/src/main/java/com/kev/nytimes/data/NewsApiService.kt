package com.kev.nytimes.data

import com.kev.nytimes.BuildConfig
import com.kev.nytimes.data.remote.dto.searchnews.SearchArticlesDTO
import com.kev.nytimes.data.remote.dto.topstories.TopStoriesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("topstories/v2/home.json")
    suspend fun getTopStories(
        @Query("api-key")apiKey: String = BuildConfig.API_KEY
    ): TopStoriesDTO

    @GET("search/v2/articlesearch.json")
    suspend fun searchArticles(
        @Query("q") articleTitle: String,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): SearchArticlesDTO
}
