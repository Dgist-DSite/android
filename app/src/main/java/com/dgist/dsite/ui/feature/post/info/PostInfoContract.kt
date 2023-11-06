package com.dgist.dsite.ui.feature.post.info

import com.dgist.dsite.remote.response.post.PostResponse

data class PostInfoState(
    val data: PostResponse = PostResponse(0, "", "", "", "", "", "", "", ""),
    val loading: Boolean = true
)

sealed class PostInfoSideEffect {
    data class ToastError(val message: String): PostInfoSideEffect()
}