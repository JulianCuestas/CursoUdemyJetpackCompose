package com.cursojetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.model.Routes

@Composable
fun Screen1(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Screen 1",
                modifier = Modifier
                .clickable { navController.navigate(Routes.Screen2.route) }
            )
            Spacer(modifier = Modifier.height(15.dp))
            ColorSimpleAnimation()
        }

    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)) {
        Text(text = "Screen 2", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navController.navigate(Routes.Screen3.route) })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Text(text = "Screen 3", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navController.navigate(Routes.Screen4.getRouteWithParam(29)) })
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column(
            modifier = Modifier
            .align(Alignment.Center)
        ) {
            Text(
                text = "Screen 4",
                modifier = Modifier.clickable {
                    navController.navigate( Routes.Screen5.getRouteWithParamOptionals("Julian") )//Routes.Screen5.route // Funciona sin parámetro
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Hola tengo $age años")
        }
    }
}

@Composable
fun Screen5(navController: NavHostController, name: String?) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "Screen 5"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Hola $name")
        }
    }
}