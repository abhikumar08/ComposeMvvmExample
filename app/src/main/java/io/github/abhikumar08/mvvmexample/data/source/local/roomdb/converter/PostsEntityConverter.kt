package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.PostEntity
import io.github.abhikumar08.mvvmexample.domain.model.Post

class PostsEntityConverter {

    @TypeConverter
    fun fromStringToPostsList(value: String): List<Post>? = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<Post>>(Types.newParameterizedType(List::class.java, Post::class.java))
        .fromJson(value)

    @TypeConverter
    fun fromPostsListTypeToString(posts: List<Post>?): String = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<Post>>(Types.newParameterizedType(List::class.java, Post::class.java))
        .toJson(posts)


    @TypeConverter
    fun fromStringToPostEntityList(value: String): List<PostEntity>? = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<PostEntity>>(
            Types.newParameterizedType(
                List::class.java,
                PostEntity::class.java
            )
        )
        .fromJson(value)

    @TypeConverter
    fun fromPostEntityListTypeToString(posts: List<PostEntity>?): String = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<PostEntity>>(
            Types.newParameterizedType(
                List::class.java,
                PostEntity::class.java
            )
        )
        .toJson(posts)
}