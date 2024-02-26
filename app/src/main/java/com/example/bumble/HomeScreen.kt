package com.example.bumble

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("Range")
@Composable
fun HomeScreen(navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = { 100 })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            val modelData = generateRandomData()
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = modelData.image),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0x00000000),
                                    Color(0x88000000),
                                    Color(0xFF000000),
                                ),
                                startY = 0.0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        )
                        .padding(start = 18.dp, end = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row {
                            Text(
                                text = modelData.name,
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = ", ${modelData.age}",
                                color = Color.White,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .background(color = Color.Transparent, shape = RectangleShape)
                                .border(
                                    width = 2.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clip(RoundedCornerShape(10.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_outward_24), // Replace with your vector resource
                                contentDescription = "Distance Icon",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(4.dp)) // Add some space between the icon and the text
                            Text(
                                text = modelData.distance,
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = modelData.profession,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = modelData.description,
                        style = TextStyle(
                            color = Color.White,
                        ),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 5.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(50), // Increase the corner radius for a more rounded look
                                modifier = Modifier
                                    .width(250.dp)
                                    .shadow(5.dp, shape = RoundedCornerShape(50))
                            ) {
                                Text(
                                    text = "Profile",
                                    color = Color.White,
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }

                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = { navController.navigate("home") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_home_filled_24),
                    contentDescription = "Home Vector Image",
                    modifier = Modifier
                        .size(27.dp),
                    colorFilter = ColorFilter.tint(LocalContentColor.current)
                )
            }
            TextButton(onClick = { navController.navigate("chat") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_chat_24),
                    contentDescription = "Chat Vector Image",
                    modifier = Modifier
                        .size(27.dp),
                    colorFilter = ColorFilter.tint(LocalContentColor.current)
                )
            }
            TextButton(onClick = { navController.navigate("profile") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Profile Vector Image",
                    modifier = Modifier
                        .size(27.dp),
                    colorFilter = ColorFilter.tint(LocalContentColor.current)
                )
            }
        }
    }
}