package com.cursojetpackcompose

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorSimpleAnimation() {
    Column() {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        val realColor = if (firstColor) Color.Red else Color.Yellow

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor }) {

        }

        Spacer(modifier = Modifier.height(50.dp))

        var secondColor by rememberSaveable { mutableStateOf(false) }
        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Blue else Color.Black)

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = !secondColor }) {
            Text(
                text = "Animación",
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}