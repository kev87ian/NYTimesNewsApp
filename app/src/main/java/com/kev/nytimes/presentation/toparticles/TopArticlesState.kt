package com.kev.nytimes.presentation.toparticles

import com.kev.nytimes.domain.model.topstories.Result

data class TopArticlesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val data: List<Result> = emptyList()

)
