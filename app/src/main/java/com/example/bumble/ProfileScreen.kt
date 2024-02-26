package com.example.bumble

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Profile Screen",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
        )
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