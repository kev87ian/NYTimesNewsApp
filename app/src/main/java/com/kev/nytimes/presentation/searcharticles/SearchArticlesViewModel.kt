package com.kev.nytimes.presentation.searcharticles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kev.nytimes.core.Resource
import com.kev.nytimes.domain.usecases.SearchArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class SearchArticlesViewModel @Inject constructor(
    private val useCase: SearchArticlesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SearchArticlesState())
    val state: State<SearchArticlesState> = _state

    private val _searchQuery = mutableStateOf<String>("")
    val searchQuery: State<String> = _searchQuery

    private var job: Job? = null
    fun searchArticles(query: String) {
        _searchQuery.value = query
        // The line below checks if there's search job anc if the search job isn't null, it cancels it.
        job?.cancel()
        job = viewModelScope.launch {
            delay(1000L)

            useCase.searchArticles(query)
                .onEach { result ->

                    when (result) {
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true,
                                errorMessage = "",
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
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                errorMessage = result.message,
                                data = emptyList()
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}
