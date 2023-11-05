package com.dgist.dsite.remote.service

import com.dgist.dsite.remote.Env
import com.dgist.dsite.remote.request.post.PostRequest
import com.dgist.dsite.remote.response.BaseResponse
import com.dgist.dsite.remote.response.post.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET(Env.Post.all)
    suspend fun getAll(

    ): BaseResponse<List<PostResponse>>

    @GET(Env.Post.category)
    suspend fun getAll(
        @Query("what") category: String
    ): BaseResponse<List<PostResponse>>

    @GET(Env.Post.one)
    suspend fun getOne(
        @Path("id") id: Int
    ): BaseResponse<PostResponse>

    @POST(Env.Post.create)
    suspend fun create(
        @Body body: PostRequest
    ): BaseResponse<String?>
}