package com.dgist.dsite.ui.feature.post

import com.dgist.dsite.remote.response.post.PostResponse

data class PostState(
    val data: List<PostResponse> = emptyList(),
    val loading: Boolean = true
)

sealed class PostSideEffect {
    data class ToastError(val message: String): PostSideEffect()
}