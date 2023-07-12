package com.todo.interview.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.todo.interview.model.Sell
import kotlinx.coroutines.flow.Flow

/**
 * Created by Hussain on 11/07/2023.
 * How it works:
 * 1. Create a Dao interface
 * 2. Annotate it with @Dao
 * 3. Create methods for insert and query
 */

@Dao
abstract class SellDao {
    @Insert
    abstract fun insertSell(sell: Sell?)

    @Query("SELECT * FROM sell")
    abstract fun getAllSell(): Flow<List<Sell>>
}