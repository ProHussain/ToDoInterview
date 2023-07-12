package com.todo.interview.network

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Hussain on 11/07/2023.
 * How it works:
 * 1. RetrofitClient is a singleton class
 * 2. It has a private constructor so that no one can create an object of this class
 * 3. It has a public static method getClient() which returns the instance of retrofit
 * 4. If the instance is null then it creates a new instance of retrofit and returns it
 * 5. If the instance is not null then it simply returns the instance
 * 6. The getClient() method is synchronized so that no two threads can access this method simultaneously
 */


object RetrofitClient {
    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .connectionPool(ConnectionPool(10, 5, TimeUnit.MINUTES))
                .addInterceptor(interceptor).build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/imkhan334/demo-1/")
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}