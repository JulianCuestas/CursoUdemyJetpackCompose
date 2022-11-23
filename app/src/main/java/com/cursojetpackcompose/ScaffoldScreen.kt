package com.cursojetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(
                onClickIcon = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                    }
                },
                onClickDrawer = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            MyDrawer {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        drawerGesturesEnabled = false
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera topbar") },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Notificaciones") }) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notifies")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = Color.Blue,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            selected = index == 0, onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
        )
        /*BottomNavigationItem(
            selected = index == 1, onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = "Tools") },
            label = { Text(text = "Tools") }
        )*/
        BottomNavigationItem(
            selected = index == 2, onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text(text = "Profile") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = {  },
        backgroundColor = Color.Yellow,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(
        Modifier.padding(8.dp)
    ) {
        Text(
            text = "Opción 1",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(text = "Opción 2", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
        Text(text = "Opción 3", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
        Text(text = "Opción 4", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
    }
}