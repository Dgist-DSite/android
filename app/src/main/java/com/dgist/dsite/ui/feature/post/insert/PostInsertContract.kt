package com.dgist.dsite.ui.feature.post.insert

data class PostInsertState(
    val loading: Boolean = false
)

sealed class PostInsertSideEffect {
    object SuccessCreate: PostInsertSideEffect()
    data class ToastError(val message: String): PostInsertSideEffect()
}