package com.dgist.dsite.utiles

import org.json.JSONObject
import retrofit2.HttpException

object Utils {

    fun convertErrorBody(throwable: HttpException): String {
        return try {
            val errorBody = JSONObject(throwable.response()?.errorBody()!!.string())
            errorBody.getString("message")
        } catch (e: Exception) {
            "알 수 없는 오류가 발생했습니다. 잠시만 기다려주세요."
        }
    }
}