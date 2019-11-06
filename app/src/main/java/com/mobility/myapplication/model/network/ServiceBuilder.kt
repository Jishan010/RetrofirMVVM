package com.mobility.myapplication.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created By JISHAN ANSARI On 11/5/2019
 */

object ServiceBuilder {
    var retrofit: Retrofit? = null
    // for logging
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(logger)
    val getServiceInstance: ServiceInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create()).client(okHttp.build()).build()
            }
            else retrofit
            return retrofit!!.create(ServiceInterface::class.java)
        }
}