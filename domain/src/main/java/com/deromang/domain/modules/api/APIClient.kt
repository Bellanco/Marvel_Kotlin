package com.deromang.domain.modules.api

import com.deromang.domain.modules.api.Constants.Constants.API_KEY
import com.deromang.domain.modules.api.Constants.Constants.PUBLIC_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest

class APIClient {

    companion object {

        private val BASE_URL = "https://gateway.marvel.com/"

        private fun getClient(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(interceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }


        fun getAPIService(): APIService {
            return getClient().create(APIService::class.java)
        }
    }

    class TokenInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val ts = System.currentTimeMillis().toString()
            var original = chain.request()
            val url = original.url.newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apikey", "d4cbf2945e0355072c5775564270101a")
                .addQueryParameter("hash", getHash(ts)).build()
            original = original.newBuilder().url(url).build()
            return chain.proceed(original)
        }

        private fun getHash(ts: String): String {
            val byte = ts.toByteArray() + API_KEY.toByteArray() + PUBLIC_KEY.toByteArray()
            val bytes = MessageDigest.getInstance("MD5").digest(byte)
            return bytes.toHex().toLowerCase()
        }

        private fun ByteArray.toHex(): String {
            return joinToString("") { "%02x".format(it) }
        }
    }


}