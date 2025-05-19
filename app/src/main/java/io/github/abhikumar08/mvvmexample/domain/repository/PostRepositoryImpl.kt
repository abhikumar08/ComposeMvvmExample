package io.github.abhikumar08.mvvmexample.domain.repository

import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao.PostDao
import io.github.abhikumar08.mvvmexample.data.source.remote.Resource
import io.github.abhikumar08.mvvmexample.data.source.remote.UsersAndPostsApiService
import io.github.abhikumar08.mvvmexample.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PostRepositoryImpl constructor(
    private val postsApiService: UsersAndPostsApiService,
    private val postsDao: PostDao,
) : PostRepository {

    override fun getPosts(): Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading())
        try {
            fetchAndSavePosts(postsApiService, postsDao)
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Oops, something went wrong"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.message ?: "Couldn't reach server. Check your internet connection."
                )
            )
        }
        //single source of truth, we will emit data from db only and not from api directly
        emit(Resource.Success(getPostsFromDb(postsDao)))
    }

    private suspend fun fetchAndSavePosts(
        postsApiService: UsersAndPostsApiService,
        postsDao: PostDao,
    ) {
        val remotePosts = postsApiService.getPosts()
        val postsEntities = remotePosts.map { it.toPostEntity() }
        postsDao.insertPosts(postsEntities)
    }

    private suspend fun getPostsFromDb(postsDao: PostDao): List<Post> {
        return postsDao.getAllPosts().map { it.toPost() }
    }
}