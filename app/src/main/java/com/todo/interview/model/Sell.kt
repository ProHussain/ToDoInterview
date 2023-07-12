package com.todo.interview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Hussain on 11/07/2023.
 * Sell model class for Room database table
 * 1. Create a data class with the name of the table
 * 2. Add @Entity annotation to the class
 * 3. Add @PrimaryKey annotation to the primary key field
 * 4. Add @ColumnInfo annotation to the fields
 */

@Entity(tableName = "sell")
data class Sell(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,
    @ColumnInfo(name = "type") val type: Int
)
