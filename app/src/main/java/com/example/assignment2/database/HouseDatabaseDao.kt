package com.example.assignment2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment2.database.entity.House
import kotlinx.coroutines.flow.Flow

@Dao
interface HouseDatabaseDao {
    @Query(value = "SELECT * FROM  my_house_list")
    fun getAll(): Flow<List<House>>

    @Query("SELECT * FROM my_house_list where houseId = :id")
    fun getById(id:Int): House?

    @Query("SELECT * FROM my_house_list ORDER BY RANDOM() LIMIT 5 ")
    fun getRandomFive(): Flow<List<House>>

    @Insert
    fun insert(house: House)

    @Query("UPDATE my_house_list SET  house_fav =:isFav where houseId =:id")
    fun toggleFav(isFav: Boolean, id: Long)
}