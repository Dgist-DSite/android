package com.dgist.dsite.ui.feature.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgist.dsite.base.BaseViewModel
import com.dgist.dsite.remote.RetrofitBuilder
import com.dgist.dsite.utiles.Resource
import com.dgist.dsite.utiles.execute
import com.dgist.dsite.utiles.launchIO
import com.dgist.dsite.utiles.launchMain
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PostViewModel: BaseViewModel<PostState, PostSideEffect>(PostState()) {

    fun load(category: String?) = launchIO {
//        Log.d("TAG", "load: ${RetrofitBuilder.getPostService().getAll()}")
        setState(
            _uiState.value.copy(
                data = emptyList(),
                loading = true
            )
        )
        val value = execute {
            if (category == null) {
                RetrofitBuilder.getPostService().getAll()
            } else {
                RetrofitBuilder.getPostService().getAll(category)
            }
        }
        Log.d("TAG", "load: $value")
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
                val message = if (it == "NOT_FOUND") "찾을 수 없습니다." else it
                sendSideEffect(PostSideEffect.ToastError(message))
            }
        ).launchIn(viewModelScope)
    }
}