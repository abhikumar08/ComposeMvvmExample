package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.UserEntity
import io.github.abhikumar08.mvvmexample.domain.model.User

class UserEntityConverter {

    @TypeConverter
    fun fromStringToUserEntityList(value: String): List<UserEntity>? = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<UserEntity>>(
            Types.newParameterizedType(
                List::class.java,
                UserEntity::class.java
            )
        )
        .fromJson(value)

    @TypeConverter
    fun fromUserEntityListTypeToString(users: List<UserEntity>?): String = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<UserEntity>>(
            Types.newParameterizedType(
                List::class.java,
                UserEntity::class.java
            )
        )
        .toJson(users)

    @TypeConverter
    fun fromStringToUserList(value: String): List<User>? = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<User>>(
            Types.newParameterizedType(
                List::class.java,
                User::class.java
            )
        )
        .fromJson(value)

    @TypeConverter
    fun fromUserListTypeToString(users: List<User>?): String = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<List<User>>(
            Types.newParameterizedType(
                List::class.java,
                User::class.java
            )
        )
        .toJson(users)


}