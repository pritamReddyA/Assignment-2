package com.example.assignment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment2.database.entity.House

@Database(entities = [(House::class)], version = 1, exportSchema = false)
abstract class HouseRoomDatabase: RoomDatabase() {
    abstract fun houseDatabaseDao() : HouseDatabaseDao

        companion object{
            @Volatile
            private var INSTANCE: HouseRoomDatabase? = null

            fun getInstance(context: Context): HouseRoomDatabase{
                synchronized(this){
                    var instance = INSTANCE

                    if(instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            HouseRoomDatabase::class.java,
                            "house_database"
                        ).fallbackToDestructiveMigration()
                            .build()

                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
}