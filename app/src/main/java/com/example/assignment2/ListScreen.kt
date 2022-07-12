package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment2.database.HouseViewModel
import com.example.assignment2.database.entity.House

@Composable
fun ListScreen(houses: List<House>?, navController: NavController, viewModel: HouseViewModel) {
    //Use popBackStack()
    Column(modifier = Modifier
        .background(color = Color(230, 230, 230, 255))
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(modifier = Modifier
            .padding(15.dp)
            .height(65.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Row() {
                Image(painter = painterResource(id = R.drawable.arrow_back), contentDescription = "Back Arrow", modifier = Modifier.clickable { navController.popBackStack() })
            }
            Row() {
                Text(text = "Trending Projects", style = TextStyle(fontWeight = FontWeight(600), fontSize = 25.sp))
            }
        }
        Column(modifier = Modifier
            .background(color = Color(241, 241, 241, 255))
            .fillMaxSize()) {
            Column(modifier = Modifier.padding(5.dp)) {
                if (houses != null) {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(houses) {
                            MainHouseCard(house = it, viewModel)
                        }
                    }
                }
            }
        }
    }
}