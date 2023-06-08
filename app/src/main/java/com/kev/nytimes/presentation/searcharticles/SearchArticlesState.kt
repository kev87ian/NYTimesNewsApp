package com.kev.nytimes.presentation.searcharticles

import com.kev.nytimes.domain.model.searcharticles.Doc

data class SearchArticlesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val data: List<Doc> = emptyList(),
    val noResults: Boolean = false
)
