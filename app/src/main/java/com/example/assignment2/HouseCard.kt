package com.example.assignment2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.createBitmap
import coil.compose.rememberAsyncImagePainter
import com.example.assignment2.database.entity.House
import org.intellij.lang.annotations.JdkConstants

@Composable
fun HouseCard(
    house: House,
//    onClick: () -> Unit
){

    Column(

        modifier = Modifier
            .padding(10.dp)
            .width(330.dp)
            .height(300.dp)
            .clickable(onClick = { }),

    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)) {
                Image(painter = painterResource(id = R.drawable.house), contentDescription = "House",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column() {
                Row() {
                    Text(text = house.houseName, maxLines = 1, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium), overflow = TextOverflow.Ellipsis, modifier = Modifier.width(250.dp))
                }
                Row() {
                    Image(painter = rememberAsyncImagePainter(house.houseOwnerLogoLink), contentDescription = "Builder Logo", modifier = Modifier
                        .width(30.dp)
                        .height(20.dp)
                        .clip(
                            CircleShape))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "mktd by ", color = Color(117,
                            117,
                            117,
                            255), style = TextStyle(fontSize = 15.sp), maxLines = 1)
                        Text(text = house.houseOwnerName.uppercase(), style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 15.sp), overflow = TextOverflow.Ellipsis, modifier = Modifier.width(280.dp),color = Color(
                            117,
                            117,
                            117,
                            255), maxLines = 1)
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = house.houseSize, overflow = TextOverflow.Ellipsis, modifier = Modifier.width(50.dp), maxLines = 1, color = Color(117,117,117,255))
                    Text(text ="• ${house.houseAddress}",overflow = TextOverflow.Ellipsis, modifier = Modifier.width(240.dp), maxLines = 1, color = Color(117,117,117,255))
                }
            }

            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.Start) {
                Text(text = "₹ ${house.houseRent}", style = MaterialTheme.typography.h6, maxLines = 1)
            }
        }
    }
}