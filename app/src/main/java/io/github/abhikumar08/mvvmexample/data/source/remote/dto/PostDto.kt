package io.github.abhikumar08.mvvmexample.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.abhikumar08.mvvmexample.data.source.local.roomdb.entity.PostEntity

@JsonClass(generateAdapter = true)
data class PostDto(
    @Json(name = "userId")
    val userId: Int?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String?,
    @Json(name = "body")
    val body: String?
) {
    fun toPostEntity(): PostEntity {
        return PostEntity(
            userId = userId,
            id = id,
            title = title,
            body = body
        )
    }
}
