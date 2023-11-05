package com.dgist.dsite.utiles

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

internal fun <R> execute(action: suspend () -> R): Flow<Resource<R>> = flow {
    try {
        emit(Resource.Loading<R>())
        val result = action.invoke()
        emit(Resource.Success<R>(result))
    } catch (e: HttpException) {
        emit(Resource.Error<R>(Utils.convertErrorBody(e)))
    } catch (e: IOException) {
        emit(Resource.Error<R>("서버에 도달할 수 없습니다."))
    } catch (e: Exception) {
        emit(Resource.Error<R>("문제가 발생했습니다."))
    }
}