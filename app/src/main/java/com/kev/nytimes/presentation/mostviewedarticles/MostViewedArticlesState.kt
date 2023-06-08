package com.kev.nytimes.presentation.mostviewedarticles

import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult

data class MostViewedArticlesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val data: List<MostViewedResult> = emptyList()
)
