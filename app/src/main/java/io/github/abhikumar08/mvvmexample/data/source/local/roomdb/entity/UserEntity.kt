package io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.abhikumar08.mvvmexample.domain.model.User

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    @ColumnInfo(name = "username")
    val userName: String?,
    val email: String?,
    val phone: String?,
    val website: String?,
) {


    // The company and address fields are not included in this entity
    fun toUser(): User {
        return User(
            id = id,
            name = name,
            userName = userName,
            email = email,
            phone = phone,
            website = website,
            company = null, // Company is not included in this entity
            address = null // Address is not included in this entity
        )
    }

    companion object {
        const val TABLE_NAME = "users"
    }
}