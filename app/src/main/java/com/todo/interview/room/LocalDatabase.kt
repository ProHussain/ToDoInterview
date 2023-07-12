package com.todo.interview.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.todo.interview.model.Sell
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by Hussain on 11/07/2023.
 * Local Database for storing data
 * How it works:
 * 1. Create an abstract class that extends RoomDatabase
 * 2. Annotate the class with @Database and define the entities and the version number
 * 3. Define an abstract method that has 0 arguments and returns the DAO class
 * 4. Create a singleton of the RoomDatabase
 * 5. Create a callback to populate the database
 */


@Database(entities = [Sell::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun sellDao(): SellDao?

    companion object {
        private var instance: LocalDatabase? = null

        @Synchronized
        fun getInstance(context: Context): LocalDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java, "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            instance?.let {
                                CoroutineScope(IO).launch {
                                    it.sellDao()?.insertSell(Sell(1, "test", 150,2,1))
                                    it.sellDao()?.insertSell(Sell(2, "test2", 250,4,1))
                                    it.sellDao()?.insertSell(Sell(3, "test3", 350,1,1))
                                }
                            }
                        }
                    })
                    .build()
            }
            return instance
        }
    }
}