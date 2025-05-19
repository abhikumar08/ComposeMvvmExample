package io.github.abhikumar08.mvvmexample.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyDto(
    @Json(name = "name")
    val name: String?,
    @Json(name = "catchPhrase")
    val catchPhrase: String?,
    @Json(name = "bs")
    val bs: String?
)
