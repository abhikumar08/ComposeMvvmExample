package io.github.abhikumar08.mvvmexample.domain.repository

import io.github.abhikumar08.mvvmexample.data.source.remote.Resource
import io.github.abhikumar08.mvvmexample.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    // Define your repository methods here
    // For example:
    suspend fun getUsers(): Flow<Resource<List<User>>>
}