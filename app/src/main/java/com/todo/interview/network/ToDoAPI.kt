package com.todo.interview.network

import com.todo.interview.model.BuyData
import com.todo.interview.model.CallData
import retrofit2.http.GET

/**
 * Created by Hussain on 11/07/2023.
 * Network interface for API calls
 * How it works:
 * 1. Create an interface with the name of the API
 * 2. Add the API calls as functions with the @GET annotation
 * 3. Return a retrofit2.Call object with the type of the response
 */

interface ToDoAPI {

    @GET("call")
    fun getCallList(): retrofit2.Call<List<CallData>>

    @GET("buy")
    fun getBuyList(): retrofit2.Call<List<BuyData>>
}