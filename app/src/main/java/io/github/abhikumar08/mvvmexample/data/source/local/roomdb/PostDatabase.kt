package io.github.abhikumar08.mvvmexample.data.source.local.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.converter.PostsEntityConverter
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.converter.UserEntityConverter
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao.PostDao
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.dao.UserDao
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.PostEntity
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.UserEntity

@Database(
    entities = [PostEntity::class, UserEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PostsEntityConverter::class, UserEntityConverter::class)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    abstract fun userDao(): UserDao


    companion object {

        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(context: Context): PostDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    "post_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}