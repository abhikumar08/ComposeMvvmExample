package io.github.abhikumar08.mvvmexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao.PostDao
import io.github.abhikumar08.mvvmexample.data.source.remote.UsersAndPostsApiService
import io.github.abhikumar08.mvvmexample.domain.repository.PostRepository
import io.github.abhikumar08.mvvmexample.domain.repository.PostRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostsRepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(
        postDao: PostDao,
        usersAndPostsApiService: UsersAndPostsApiService
    ): PostRepository {
        return PostRepositoryImpl(usersAndPostsApiService, postDao)
    }


}