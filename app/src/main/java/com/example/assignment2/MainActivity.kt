package com.example.assignment2

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignment2.database.HouseViewModel
import com.example.assignment2.database.entity.House
import com.example.assignment2.ui.theme.Assignment2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : HouseViewModel by viewModels()

    lateinit var navController: NavHostController

//    val house1 = House(
//        houseName = "Utpal Appartments",
//        houseOwnerName = "Banjara Constructions",
//        houseSize = "6BHK",
//        houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
//        houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
//        houseRent = "95,000",
//        fav = false
//    )
//    val house2 = House(
//        houseName = "Rock Side Hills",
//        houseOwnerName = "Banjara Constructions",
//        houseSize = "1BHK",
//        houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
//        houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
//        houseRent = "50,000",
//        fav = false
//    )
//    val house3 = House(
//        houseName = "Saral Hills",
//        houseOwnerName = "Banjara Constructions",
//        houseSize = "4BHK",
//        houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
//        houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
//        houseRent = "15,000",
//        fav = false
//    )
//    val house4 = House(
//        houseName = "Pushpa Enclave",
//        houseOwnerName = "Banjara Constructions",
//        houseSize = "3BHK",
//        houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
//        houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
//        houseRent = "45,000",
//        fav = false
//    )
//    val house5 = House(
//        houseName = "Rocky Hills",
//        houseOwnerName = "Banjara Constructions",
//        houseSize = "3BHK",
//        houseAddress = "502, Nitya Enclve, Beside Drishti Eye Hospital, Hyderabad, Telanagana, 500073",
//        houseOwnerLogoLink = "https://images.fastcompany.net/image/upload/w_1280,f_auto,q_auto,fl_lossy/w_596,c_limit,q_auto:best,f_auto/fc/3034007-inline-i-applelogo.jpg",
//        houseRent = "55,000",
//        fav = false
//    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        viewModel.addHouse(house1)
//        viewModel.addHouse(house2)
//        viewModel.addHouse(house3)
//        viewModel.addHouse(house4)
//        viewModel.addHouse(house5)
        setContent {
            Assignment2Theme {

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    navController = rememberNavController()

                    

                    val houses by viewModel.houses.collectAsState()
                    val fiveHouses by viewModel.fiveHouses.collectAsState()
                    Log.e("houses", fiveHouses.toString())
                    SetupGraph(navHostController = navController, houses, fiveHouses, viewModel)

                }
            }
        }
    }

}






