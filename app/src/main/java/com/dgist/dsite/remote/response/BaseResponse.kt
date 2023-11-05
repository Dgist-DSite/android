package com.dgist.dsite.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse <T> (
    @field:SerializedName("data")
    val data: T,
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("status")
    val status: String,
)