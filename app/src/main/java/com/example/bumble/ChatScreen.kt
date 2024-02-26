package com.example.bumble

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ChatScreen(navController: NavHostController) {
    val modelDataList = remember { List(9) { generateRandomData() } }
    val scrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "MATCHES",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(start = 20.dp, top = 30.dp, bottom = 20.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFFD1D0CE),
                textAlign = TextAlign.Left
            )
        )
        LazyRow(
            state = scrollState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(modelDataList) { modelData ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(90.dp)
                            .border(
                                shape = CircleShape,
                                width = 2.dp,
                                color = Color(0xFFEB5406)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = modelData.image),
                            contentDescription = "model images",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        text = modelData.name,
                        modifier = Modifier.padding(top = 4.dp),
                        style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }




        /////////////////////////////////////////////////////////////
        Spacer(modifier = Modifier.weight(1f))
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