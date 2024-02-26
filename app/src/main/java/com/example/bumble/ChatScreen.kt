package com.example.bumble

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavHostController) {
    // Generating a list of random data to display in the chat screen
    val modelDataList = remember { List(9) { generateRandomData() } }
    // Remembering the scroll state of the LazyRow
    val scrollState = rememberLazyListState()

    // Column composable for arranging UI elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text composable for displaying "MATCHES" text aligned to the left
        Text(
            text = "MATCHES",
            textAlign = TextAlign.Start, // Aligning text to the start (left)
            modifier = Modifier
                .padding(start = 20.dp, top = 30.dp, bottom = 20.dp)
                .fillMaxWidth(), // Making the text fill the width of the column
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFFD1D0CE),
                textAlign = TextAlign.Start // Aligning text to the start (left)
            )
        )
        // LazyRow composable for horizontally scrolling items
        LazyRow(
            state = scrollState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Iterating through the modelDataList to display items
            items(modelDataList) { modelData ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Box composable for wrapping the image with a border
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
                        // Image composable for displaying model images
                        Image(
                            painter = painterResource(id = modelData.image),
                            contentDescription = "model images",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }
                    // Text composable for displaying model name
                    Text(
                        text = modelData.name,
                        modifier = Modifier.padding(top = 4.dp),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                    )
                }
            }
        }
        // Search composable for displaying search bar
        Search()
        Chat()

        // Spacer composable for pushing content to the bottom
        Spacer(modifier = Modifier.weight(1f))
        // Row composable for arranging buttons horizontally
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Button for navigating to the home screen
            TextButton(onClick = { navController.navigate("home") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_home_filled_24),
                    contentDescription = "Home Vector Image",
                    modifier = Modifier
                        .size(27.dp),
                    colorFilter = ColorFilter.tint(LocalContentColor.current)
                )
            }
            // Button for navigating to the chat screen (current screen)
            TextButton(onClick = { navController.navigate("chat") }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_chat_24),
                    contentDescription = "Chat Vector Image",
                    modifier = Modifier
                        .size(27.dp),
                    colorFilter = ColorFilter.tint(LocalContentColor.current)
                )
            }
            // Button for navigating to the profile screen
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    // TextField composable for searching functionality
    val (value, onValueChange) = remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 6.sp),
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(40.dp)), // Add this line
        placeholder = { Text(text = "Search") },
        trailingIcon = {
            Icon(
                Icons.Filled.Search,
                null,
                tint = Color.Gray,
                modifier = Modifier.clickable { /*Click Action*/ })
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.DarkGray,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Chat() {
//    val modelData = generateRandomData()
    val scrollState = rememberLazyListState()
    val modelDataList = remember { List(10) { generateRandomData() } }
    // Text composable for displaying chat screen
    Text(
        text = "CHATS",
        textAlign = TextAlign.Start, // Aligning text to the start (left)
        modifier = Modifier
            .padding(start = 20.dp, top = 30.dp, bottom = 20.dp)
            .fillMaxWidth(), // Making the text fill the width of the column
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color(0xFFD1D0CE),
            textAlign = TextAlign.Start // Aligning text to the start (left)
        )
    )

    /*Column {
        // LazyColumn for displaying chat messages
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp)
        ) {
            // Limiting the number of items to 15
            repeat(15) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Image composable for displaying model images
                        Image(
                            painter = painterResource(id = modelData.image),
                            contentDescription = "model images",
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape) // Clip the image into a circle
                                .padding(end = 10.dp) // Add padding between image and message
                        )
                        // Placeholder text for chat message
                        Text(
                            text = "Chat message $it",
                            style = TextStyle(fontSize = 16.sp)
                        )
                    }
                }
            }
        }
    }*/
    LazyColumn(
        state = scrollState,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 0.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(modelDataList) { modelData ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                // Image composable for displaying model images
                Image(
                    painter = painterResource(id = modelData.image),
                    contentDescription = "model images",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )

                // Text composable for displaying model name
                Text(
                    text = modelData.name,
                    modifier = Modifier.padding(start = 8.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
            }
        }
    }
}