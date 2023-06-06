package com.kev.nytimes.domain.usecases

import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.model.searchnews.Doc
import com.kev.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchArticlesUseCase constructor(
    private val repository: NewsRepository
) {


    suspend fun searchArticles(query: String) : Flow<Resource<List<Doc>>>{
        return repository.searchArticles(query)
    }
}