package com.example.assignment2.database

import androidx.lifecycle.LiveData
import com.example.assignment2.database.entity.House
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class HouseRepository @Inject constructor(private val houseDatabaseDao: HouseDatabaseDao) {

    val selectAll = houseDatabaseDao.getAll()
    val fiveRandom = houseDatabaseDao.getRandomFive()

    suspend fun addHouses(){
        val house1 = House(
            houseName = "Sweet Home Hills",
            houseOwnerName = "Banjara Constructions",
            houseSize = "3BHK",
            houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
            houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
            houseRent = "35,000",
            fav = false
        )
        val house2 = House(
            houseName = "Sweet Home Hills",
            houseOwnerName = "Banjara Constructions",
            houseSize = "3BHK",
            houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
            houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
            houseRent = "35,000",
            fav = false
        )
        val house3 = House(
            houseName = "Sweet Home Hills",
            houseOwnerName = "Banjara Constructions",
            houseSize = "3BHK",
            houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
            houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
            houseRent = "35,000",
            fav = false
        )
        val house4 = House(
            houseName = "Sweet Home Hills",
            houseOwnerName = "Banjara Constructions",
            houseSize = "3BHK",
            houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
            houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
            houseRent = "35,000",
            fav = false
        )
        val house5 = House(
            houseName = "Sweet Home Hills",
            houseOwnerName = "Banjara Constructions",
            houseSize = "3BHK",
            houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
            houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
            houseRent = "35,000",
            fav = false
        )
        Dispatchers.IO.apply {
            houseDatabaseDao.insert(house1)
            houseDatabaseDao.insert(house2)
            houseDatabaseDao.insert(house3)
            houseDatabaseDao.insert(house4)
            houseDatabaseDao.insert(house5)
        }
    }



    suspend fun addHouse(house: House){
        Dispatchers.IO.apply {
            houseDatabaseDao.insert(house)
        }
    }

    suspend fun toggleFav(isFav: Boolean, id: Long){
        Dispatchers.IO.apply {
            houseDatabaseDao.toggleFav(isFav, id)
        }
    }
}