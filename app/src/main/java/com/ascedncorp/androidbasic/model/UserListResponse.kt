package com.ascedncorp.androidbasic.model

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("per_page") val perPage: Int? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("total_page") val totalPage: Int? = null,
    @SerializedName("data") val data: List<DataItem>? = null,
    @SerializedName("support") val support: Support? = null,
)

data class DataItem(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("first_name") val first_name: String? = null,
    @SerializedName("last_name") val last_name: String? = null,
    @SerializedName("avatar") val avatar: String? = null,
)

data class Support(
    @SerializedName("url") val url: String? = null,
    @SerializedName("text") val text: String? = null,
)
