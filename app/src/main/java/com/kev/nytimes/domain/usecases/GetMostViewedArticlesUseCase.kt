package com.kev.nytimes.domain.usecases

import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult
import com.kev.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetMostViewedArticlesUseCase  constructor(
    private val repository: NewsRepository
) {

    suspend fun getMostViewedArticles(): Flow<Resource<List<MostViewedResult>>> {
        return repository.getMostViewedArticles()
    }
}

