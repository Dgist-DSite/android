package com.dgist.dsite.ui.feature.post.info

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dgist.dsite.base.BaseViewModel
import com.dgist.dsite.remote.Env.Post.category
import com.dgist.dsite.remote.RetrofitBuilder
import com.dgist.dsite.ui.feature.post.PostSideEffect
import com.dgist.dsite.utiles.execute
import com.dgist.dsite.utiles.launchIO
import kotlinx.coroutines.flow.launchIn

class PostInfoViewModel: BaseViewModel<PostInfoState, PostInfoSideEffect>(PostInfoState()) {

    fun load(id: Int) = launchIO {
        val value = execute {
            RetrofitBuilder.getPostService().getOne(id)
        }
        value.divideResult(
            successAction = {
                setState(
                    _uiState.value.copy(
                        data = it.data,
                        loading = false
                    )
                )
            },
            errorAction = {
                sendSideEffect(PostInfoSideEffect.ToastError(it))
            }
        ).launchIn(viewModelScope)
    }
}