package com.kev.nytimes.presentation.mostviewedarticles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.usecases.GetMostViewedArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MostViewedArticlesViewModel @Inject constructor(
    private val useCase: GetMostViewedArticlesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MostViewedArticlesState())
    val state: State<MostViewedArticlesState> = _state

    fun getMostViewedArticles() = viewModelScope.launch(Dispatchers.IO) {
        useCase.getMostViewedArticles().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        errorMessage = "",
                        data = result.data
                    )
                }
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true,
                        errorMessage = "",
                        data = emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        errorMessage = result.message,
                        data = emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
