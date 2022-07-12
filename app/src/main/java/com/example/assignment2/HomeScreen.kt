package com.example.assignment2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment2.database.entity.House

@Composable
fun HomeScreen(houses: List<House>?, navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column() {
           Column(modifier = Modifier.padding(top = 0.dp, start = 25.dp, end = 35.dp, bottom = 0.dp).height(50.dp), verticalArrangement = Arrangement.SpaceBetween) {
               Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                   Text(text = "Trending Projects", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                   Text(text = "See all", Modifier.clickable { navController.navigate(route = Screen.List.route) }, style = TextStyle(color = Color(
                       66,
                       67,
                       151,
                       255), fontWeight = FontWeight.Bold), fontSize = 15.sp)
               }
               Row() {
                   Text(text = "Most seen projects by buyers in Gurgaon",color = Color(160,
                       160,
                       160,
                       255))
               }
           }


            if (houses != null) {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(houses) {
                        HouseCard(house = it)
                    }
                }
            }
        }
    }
}