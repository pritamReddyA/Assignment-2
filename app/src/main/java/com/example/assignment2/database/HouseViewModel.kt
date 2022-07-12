package com.example.assignment2.database

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.example.assignment2.database.entity.House
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class HouseViewModel @Inject constructor(private val repository: HouseRepository) : ViewModel() {



    private val _readAllData: MutableStateFlow<List<House>?> = MutableStateFlow(null)
    val houses : StateFlow<List<House>?> = _readAllData

    private val _readFiveHouses: MutableStateFlow<List<House>?> = MutableStateFlow(null)
    val fiveHouses : StateFlow<List<House>?> = _readFiveHouses


    init {
        getHouses()
        getFiveHouses()
    }

    private fun getHouses(){
       viewModelScope.launch(Dispatchers.IO){
           repository.selectAll.collect(){ it ->
               _readAllData.emit(it)
           }
       }
    }

    private fun getFiveHouses(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.fiveRandom.collect(){
                _readFiveHouses.emit(it)
            }
        }
    }



    fun addHouse(house: House){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHouse(house)
        }
    }



    fun toggleFavHouse(isFav: Boolean, id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            Log.e("isFav", "$isFav")
            repository.toggleFav(isFav, id)
        }
    }
}

//class HouseViewModel(private val houseDatabaseDao: HouseDatabaseDao): ViewModel(){
//    fun fullHouses() : List<House> = houseDatabaseDao.getAll()
//
//    fun getRandomFive(): List<House> = houseDatabaseDao.getRandomFive()
//}
//
//
//class HouseViewModelFactory(
//    private val houseDatabaseDao: HouseDatabaseDao
//) : ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(HouseViewModel::class.java)){
//            @Suppress("UNCHECKED_CAST")
//            return HouseViewModel(houseDatabaseDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//    }
//}

