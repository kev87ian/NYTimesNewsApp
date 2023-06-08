package com.kev.nytimes.presentation.toparticles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.usecases.GetTopArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopArticlesViewModel @Inject constructor(
    private val topArticlesUseCase: GetTopArticlesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TopArticlesState())
    val state: State<TopArticlesState> = _state

    fun getTopArticles() = viewModelScope.launch(Dispatchers.IO) {
        topArticlesUseCase.getTopArticles().onEach { result ->

            when (result) {
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
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        errorMessage = "",
                        data = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
