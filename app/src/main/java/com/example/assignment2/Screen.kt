package com.example.assignment2

sealed class Screen(val route : String){
    object Home: Screen(route = "home_screen")
    object List: Screen(route = "list_screen")
}
