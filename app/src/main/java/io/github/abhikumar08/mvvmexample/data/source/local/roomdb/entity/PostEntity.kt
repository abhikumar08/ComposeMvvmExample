package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.abhikumar08.mvvmexample.domain.model.Post

@Entity(
    tableName = PostEntity.TABLE_NAME,
)
data class PostEntity(
    @ColumnInfo(name = "user_id")
    val userId: Int?,
    @PrimaryKey
    val id: Int,
    val title: String?,
    val body: String?
) {
    fun toPost(): Post {
        return Post(
            userId = userId,
            id = id,
            title = title,
            body = body
        )
    }

    companion object {
        const val TABLE_NAME = "posts"
    }
}
