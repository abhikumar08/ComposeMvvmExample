package io.github.abhikumar08.mvvmexample.presentation.viewmodel

import io.github.abhikumar08.mvvmexample.domain.model.Post

data class PostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
) {

}