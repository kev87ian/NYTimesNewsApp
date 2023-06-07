package com.kev.nytimes.domain.repository

import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult
import com.kev.nytimes.domain.model.searchnews.Doc
import com.kev.nytimes.domain.model.topstories.Result
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getTopStories(): Flow<Resource<List<Result>>>
    suspend fun searchArticles(query: String): Flow<Resource<List<Doc>>>
    suspend fun getMostViewedArticles(): Flow<Resource<List<MostViewedResult>>>
}