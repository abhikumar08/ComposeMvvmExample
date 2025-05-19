package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.UserEntity

@Dao
interface UserDao {

    // Define your DAO methods here
    // For example:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>
}