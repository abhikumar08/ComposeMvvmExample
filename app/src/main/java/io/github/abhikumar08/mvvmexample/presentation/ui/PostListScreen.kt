package io.github.abhikumar08.mvvmexample.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.abhikumar08.mvvmexample.presentation.viewmodel.PostsViewModel

@Preview(showBackground = true)
@Composable
fun PostListScreen(postsViewModel: PostsViewModel = hiltViewModel()) {
    val state = postsViewModel.state.value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
    ) {
        items(state.posts.size) { index ->
            val post = state.posts[index]
            PostItem(title = post.title ?: "", body = post.body ?: "")
            if (index < state.posts.size - 1) {
                HorizontalDivider()
            }
        }

    }
}