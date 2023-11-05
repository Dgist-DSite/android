package com.dgist.dsite.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgist.dsite.utiles.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : Any, SIDE_EFFECT> constructor(
    state: STATE
): ViewModel() {

    protected val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()

    protected val _sideEffect = Channel<SIDE_EFFECT>()
    val sideEffect = _sideEffect.receiveAsFlow()

    protected fun setState(
        state: STATE
    ) {
        _uiState.value = state
    }

    protected fun sendSideEffect(
        sideEffect: SIDE_EFFECT
    ) = viewModelScope.launch(Dispatchers.IO) {
        _sideEffect.send(sideEffect)
    }

    fun <T> Flow<Resource<T>>.divideResult(
        successAction: (T) -> Unit,
        errorAction: (String) -> Unit
    ) = onEach { resource ->
        Log.d("TAG", "divideResult:1232312 ")
        when (resource) {
            is Resource.Success -> {
                Log.d("TAG", "divideResult:1232312 ")
                successAction.invoke(resource.data!!)
            }
            is Resource.Loading -> {
                Log.d("TAG", "divideResult:1232312 ")
            }
            is Resource.Error -> {
                Log.d("TAG", "divideResult:1232312 ")
                errorAction.invoke(resource.message!!)
            }
        }
    }
}