package com.todo.interview.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.todo.interview.model.BuyData
import com.todo.interview.model.CallData
import com.todo.interview.model.Sell
import com.todo.interview.network.RetrofitClient
import com.todo.interview.network.ToDoAPI
import com.todo.interview.room.LocalRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import retrofit2.Callback

/**
 * Created by Hussain on 11/07/2023.
 * ToDoListViewModel is a ViewModel class which is used to fetch data from API and Room Database
 * and pass it to the UI.
 * How it works:
 * 1. It extends AndroidViewModel class which is a subclass of ViewModel class.
 * 2. It has MutableLiveData objects which are used to store the data fetched from API and Room Database.
 * 3. It has a function loadList() which is used to fetch data from API and Room Database.
 * 4. Inside loadList() function, we are using Retrofit to fetch data from API and Room Database.
 * 5. We are using Moshi to parse the JSON data fetched from API.
 * 6. We are using Room Database to fetch data from local database.
 * 7. We are using Coroutines to fetch data from Room Database.
 */


class ToDoListViewModel(application: Application) : AndroidViewModel(application) {

    var callDataList: MutableLiveData<List<CallData>> = MutableLiveData<List<CallData>>()
    var buyDataList: MutableLiveData<List<BuyData>> = MutableLiveData<List<BuyData>>()
    var sellDataList: MutableLiveData<List<Sell>> = MutableLiveData<List<Sell>>()

    fun loadList(listType: String) {
        val retrofit = RetrofitClient.client
        val todoApi = retrofit?.create(ToDoAPI::class.java)
        when (listType) {
            "call" -> {
                todoApi?.getCallList()?.enqueue(object : Callback<List<CallData>> {
                    override fun onResponse(
                        callData: retrofit2.Call<List<CallData>>,
                        response: retrofit2.Response<List<CallData>>
                    ) {
                        val list = response.body()
                        callDataList.value = list
                    }

                    override fun onFailure(callData: retrofit2.Call<List<CallData>>, t: Throwable) {
                        Log.e("onFailure", t.message.toString())
                    }
                })
            }

            "buy" -> {
                todoApi?.getBuyList()?.enqueue(object : Callback<List<BuyData>> {
                    override fun onResponse(
                        callData: retrofit2.Call<List<BuyData>>,
                        response: retrofit2.Response<List<BuyData>>
                    ) {
                        val list = response.body()
                        buyDataList.value = list
                    }

                    override fun onFailure(callData: retrofit2.Call<List<BuyData>>, t: Throwable) {
                        Log.e("onFailure", t.message.toString())
                    }
                })
            }

            "sale" -> {
                viewModelScope.launch { // launch a new coroutine in background and continue
                    val localRepository = LocalRepository(getApplication())
                    val list = localRepository.getAllSell()
                    sellDataList.value = list.firstOrNull()
                }
            }

            else -> {
                Toast.makeText(getApplication(), "else", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
