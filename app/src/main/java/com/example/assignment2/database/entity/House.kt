package com.example.assignment2.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_house_list")
data class House(
    @PrimaryKey(autoGenerate = true)
    var houseId : Long = 0,
    @ColumnInfo(name = "house_name")
    var houseName: String,
    @ColumnInfo(name = "house_owner_name")
    var houseOwnerName: String,
    @ColumnInfo(name = "house_size")
    var houseSize: String,
    @ColumnInfo(name = "house_address")
    var houseAddress: String,
    @ColumnInfo(name = "house_owner_logo")
    var houseOwnerLogoLink: String,
    @ColumnInfo(name = "house_rent")
    var houseRent: String,
    @ColumnInfo(name = "house_fav")
    var fav: Boolean = false
)
