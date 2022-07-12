package com.example.assignment2

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment2.database.HouseViewModel
import com.example.assignment2.database.entity.House

@Composable
fun SetupGraph(
    navHostController: NavHostController, houses: List<House>?, fiveHouses: List<House>?, viewModel: HouseViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(fiveHouses, navHostController)
        }

        composable(
            route = Screen.List.route
        ){
            ListScreen(houses, navHostController, viewModel)
        }
    }
}