package io.github.abhikumar08.mvvmexample.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.abhikumar08.mvvmexample.data.source.remote.Resource
import io.github.abhikumar08.mvvmexample.domain.usecase.GetPosts
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val getPosts: GetPosts) : ViewModel() {

    private val _state = mutableStateOf(PostsUiState())
    val state: State<PostsUiState> = _state

    init {
        fetchPosts()
    }


    private fun fetchPosts() {
        viewModelScope.launch {
            getPosts().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = PostsUiState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _state.value = PostsUiState(posts = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _state.value = PostsUiState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}