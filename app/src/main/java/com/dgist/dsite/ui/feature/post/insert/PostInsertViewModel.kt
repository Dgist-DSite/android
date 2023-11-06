package com.dgist.dsite.ui.feature.post.insert

import androidx.lifecycle.viewModelScope
import com.dgist.dsite.base.BaseViewModel
import com.dgist.dsite.remote.RetrofitBuilder
import com.dgist.dsite.remote.request.post.PostRequest
import com.dgist.dsite.ui.feature.post.info.PostInfoSideEffect
import com.dgist.dsite.ui.feature.post.info.PostInfoState
import com.dgist.dsite.utiles.execute
import com.dgist.dsite.utiles.launchIO
import kotlinx.coroutines.flow.launchIn

class PostInsertViewModel: BaseViewModel<PostInsertState, PostInsertSideEffect>(PostInsertState()) {

    fun insert(
        category: String,
        url: String,
        content: String
    ) = launchIO {
        setState(
            _uiState.value.copy(
                loading = true
            )
        )
        val value = execute {
            RetrofitBuilder.getPostService().create(
                PostRequest(
                    userName = "익명의 대소고인",
                    category = category,
                    url = url,
                    content = content,
                )
            )
        }
        value.divideResult(
            successAction = {
                setState(
                    _uiState.value.copy(
                        loading = false
                    )
                )
                sendSideEffect(PostInsertSideEffect.SuccessCreate)
            },
            errorAction = {
                setState(
                    _uiState.value.copy(
                        loading = false
                    )
                )
                sendSideEffect(PostInsertSideEffect.ToastError(it))
            }
        ).launchIn(viewModelScope)
    }
}