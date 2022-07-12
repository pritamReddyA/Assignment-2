package com.example.assignment2.di

import android.content.Context
import com.example.assignment2.database.HouseDatabaseDao
import com.example.assignment2.database.HouseRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun getAppDB(@ApplicationContext context: Context) : HouseRoomDatabase{
        return HouseRoomDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb: HouseRoomDatabase): HouseDatabaseDao{
        return appDb.houseDatabaseDao()
    }
}