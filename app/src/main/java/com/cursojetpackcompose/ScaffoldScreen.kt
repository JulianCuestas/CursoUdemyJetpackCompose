package com.cursojetpackcompose

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyScaffold() {
    Scaffold(
        topBar = { MyTopAppBar() }
    ) {

    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "Mi primera topbar") },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "search")
            }
        }
    )
}