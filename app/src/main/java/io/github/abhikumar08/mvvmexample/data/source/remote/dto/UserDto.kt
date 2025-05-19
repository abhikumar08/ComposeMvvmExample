package io.github.abhikumar08.mvvmexample.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "username")
    val userName: String?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "phone")
    val phone: String?,
    @Json(name = "website")
    val website: String?,
    @Json(name = "company")
    val company: CompanyDto?,
    @Json(name = "address")
    val address: AddressDto?
)
