package com.dgist.dsite.remote

import com.dgist.dsite.BuildConfig
import com.dgist.dsite.remote.service.PostService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class RetrofitBuilder {
    companion object {
        private var instance: Retrofit? = null
        private var postService: PostService? = null
        @Synchronized
        fun getInstance(): Retrofit {
            if (instance == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val okhttpBuilder = OkHttpClient().newBuilder()
                    .addInterceptor(interceptor)
                val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                    override fun getAcceptedIssuers(): Array<X509Certificate> { return arrayOf() }
                })

                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())

                val sslSocketFactory = sslContext.socketFactory

                okhttpBuilder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                okhttpBuilder.hostnameVerifier { hostname, session -> true }
                okhttpBuilder.connectTimeout(30, TimeUnit.SECONDS)
                okhttpBuilder.readTimeout(30, TimeUnit.SECONDS)
                okhttpBuilder.writeTimeout(30, TimeUnit.SECONDS)
                val okHttpClient =  okhttpBuilder.build()

                val gson = GsonBuilder().create()
                instance = Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()
            }
            return instance!!
        }

        @Synchronized
        fun getPostService(): PostService {
            if (postService == null) {
                postService = getInstance().create(PostService::class.java)
            }
            return postService!!
        }
    }
}