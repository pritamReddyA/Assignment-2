package com.example.assignment2.database

import com.example.assignment2.database.entity.House

data class User(
    var houseList: MutableList<House>,
    var favHouseList : MutableList<House>
)
