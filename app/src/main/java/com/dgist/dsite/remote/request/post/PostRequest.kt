package com.dgist.dsite.remote.request.post

import com.google.gson.annotations.SerializedName

data class PostRequest (
    @field:SerializedName("userName")
    val userName: String,
    @field:SerializedName("url")
    val url: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("category")
    val category: String,
)