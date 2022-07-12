package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.assignment2.database.HouseViewModel
import com.example.assignment2.database.entity.House

@Composable
fun MainHouseCard(house: House, viewModel: HouseViewModel){

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(350.dp),
            elevation = 5.dp, shape = RoundedCornerShape(10.dp)
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)) {
                Image(painter = painterResource(id = R.drawable.house), contentDescription = "House",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.Start) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "₹ ${house.houseRent}",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight(700)),
                        maxLines = 1)
                    FavoriteButton(modifier = Modifier, isChecked = house.fav, viewModel = viewModel, houseId = house.houseId)
                }
            }
                Row(modifier = Modifier.width(400.dp), horizontalArrangement = Arrangement.SpaceBetween) {


                    Column() {
                            Text(text = house.houseOwnerName.uppercase(),
                                style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 15.sp),
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.width(250.dp),
                                color = Color(
                                    117,
                                    117,
                                    117,
                                    255),
                                maxLines = 1)
//                    Text(text = house.houseSize, overflow = TextOverflow.Ellipsis, modifier = Modifier.width(50.dp), maxLines = 1, color = Color(117,117,117,255))
                            Text(text = house.houseAddress,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.width(300.dp),
                                maxLines = 1,
                                color = Color(117, 117, 117, 255))
                    }

                }


            Divider(color= Color(228, 228, 228, 255), thickness = 1.dp)

            Column() {

                        Row(verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = rememberAsyncImagePainter(house.houseOwnerLogoLink),
                                contentDescription = "Builder Logo",
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(20.dp)
                                    .clip(
                                        CircleShape),
                            )
                            Column() {
                                Text(text = house.houseName,
                                    maxLines = 1,
                                    style = TextStyle(fontSize = 18.sp,
                                        fontWeight = FontWeight(400)),
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.width(150.dp))
                                Text(text = "Seller", style = TextStyle(color = Color(153,
                                    153,
                                    153,
                                    255)))
                            }
                            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier
                                .width(120.dp)
                                .height(50.dp), shape = RoundedCornerShape(10.dp)) {
                                Text(text = "View Phone")
                            }

                }
            }

        }
    }

}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Red, isChecked: Boolean, viewModel: HouseViewModel, houseId: Long
) {

    var isFavorite by remember { mutableStateOf(isChecked) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
            viewModel.toggleFavHouse(isFavorite,houseId)
        }
    ) {
        Icon(
            tint = Color.Gray,

            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}