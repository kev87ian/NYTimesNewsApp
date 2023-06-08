package com.kev.nytimes.domain.usecases

import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.model.searcharticles.Doc
import com.kev.nytimes.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchArticlesUseCase constructor(
    private val repository: NewsRepository
) {


    suspend fun searchArticles(query: String) : Flow<Resource<List<Doc>>>{
      if (query.isEmpty()){
          return flow {  }
      }
        return repository.searchArticles(query)
    }
}