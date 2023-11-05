package com.dgist.dsite.remote.response.post

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("category")
    val category: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("image")
    val image: String,
    @field:SerializedName("regDate")
    val regDate: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("url")
    val url: String,
    @field:SerializedName("userName")
    val userName: String
)