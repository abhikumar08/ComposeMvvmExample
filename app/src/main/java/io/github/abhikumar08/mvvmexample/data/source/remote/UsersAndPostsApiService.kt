package io.github.abhikumar08.mvvmexample.data.source.remote

import io.github.abhikumar08.mvvmexample.data.source.remote.dto.PostDto
import io.github.abhikumar08.mvvmexample.data.source.remote.dto.UserDto
import retrofit2.http.GET

interface UsersAndPostsApiService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("/posts/{id}")
    suspend fun getPostById(id: Int): PostDto

    @GET("/users")
    suspend fun getUsers(): List<UserDto>
}