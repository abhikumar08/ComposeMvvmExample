package io.github.abhikumar08.mvvmexample.domain.usecase

import io.github.abhikumar08.mvvmexample.data.source.remote.Resource
import io.github.abhikumar08.mvvmexample.domain.model.Post
import io.github.abhikumar08.mvvmexample.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPosts(private val postRepository: PostRepository) {

    operator fun invoke(): Flow<Resource<List<Post>>> {
        return postRepository.getPosts()
    }
}