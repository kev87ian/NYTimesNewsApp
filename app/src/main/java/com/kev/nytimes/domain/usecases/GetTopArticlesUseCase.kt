package com.kev.nytimes.domain.usecases

import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.model.topstories.Result
import com.kev.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetTopArticlesUseCase constructor(
    private val repository: NewsRepository
) {
    suspend fun getTopArticles() : Flow<Resource<List<Result>>> {
        return repository.getTopStories()
    }

}