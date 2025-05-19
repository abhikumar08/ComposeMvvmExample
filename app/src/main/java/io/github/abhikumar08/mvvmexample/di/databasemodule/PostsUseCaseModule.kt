package io.github.abhikumar08.mvvmexample.di.databasemodule

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.abhikumar08.mvvmexample.domain.usecase.GetPosts
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostsUseCaseModule {

    @Provides
    @Singleton
    fun providePostUseCase(
        postRepository: io.github.abhikumar08.mvvmexample.domain.repository.PostRepository
    ): GetPosts = GetPosts(postRepository)

}