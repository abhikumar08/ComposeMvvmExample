package io.github.abhikumar08.mvvmexample.di.databasemodule

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.PostDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostsDatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) = PostDatabase.getDatabase(application)

    @Provides
    @Singleton
    fun providesPostDao(db: PostDatabase) = db.postDao()

    @Provides
    @Singleton
    fun providesUserDao(db: PostDatabase) = db.userDao()
}