package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.PostEntity

@Dao
interface PostDao {
    // Define your DAO methods here
    // For example:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<PostEntity>


}