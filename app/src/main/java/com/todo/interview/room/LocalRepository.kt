package com.todo.interview.room

import android.content.Context
import com.todo.interview.model.Sell
import kotlinx.coroutines.flow.Flow

/**
 * Created by Hussain on 11/07/2023.
 * LocalRepository is a class that is used to access the database.
 * It is used to access the database from the viewmodel.
 * It is used to insert and get all the data from the database.
 */

class LocalRepository(context: Context) {
    var db: SellDao = LocalDatabase.getInstance(context)!!.sellDao()!!

     suspend fun insertSell(sell: Sell?) {
        db.insertSell(sell)
    }

     suspend fun getAllSell(): Flow<List<Sell>> {
         return db.getAllSell()
     }
 }