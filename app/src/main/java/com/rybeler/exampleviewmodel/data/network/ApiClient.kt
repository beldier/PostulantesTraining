package com.rybeler.exampleviewmodel.data.network

import com.rybeler.exampleviewmodel.utils.generateHash
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.Date

//https://mocki.io/v1/5f58c3bd-a68f-4cca-b9b3-c09511383b50
const val API_ENDPOINT = "https://gateway.marvel.com/"
// singleton
object ApiClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(QueryInterceptor())
        .build()



    private val restAdapter = Retrofit.Builder()
        .baseUrl(API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val charactersService: CharacterService = restAdapter.create()

}

private class QueryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url

        val ts = Date().time
        val hash = generateHash(ts, "cec08f373843c610820543716b92d1036f7a5ec4", "796693a7d0db6653c1eb313d38a938f3")

        val url = originalUrl.newBuilder()
            .addQueryParameter("apikey", "796693a7d0db6653c1eb313d38a938f3")
            .addQueryParameter("ts", ts.toString())
            .addQueryParameter("hash", hash)
            .build()

        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}