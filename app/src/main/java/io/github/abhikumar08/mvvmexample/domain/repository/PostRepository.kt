package io.github.abhikumar08.mvvmexample.domain.repository

import io.github.abhikumar08.mvvmexample.data.source.remote.Resource
import io.github.abhikumar08.mvvmexample.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<Resource<List<Post>>>
}