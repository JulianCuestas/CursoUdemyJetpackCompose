package com.cursojetpackcompose

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

        var activeChangeText  by rememberSaveable { mutableStateOf(false) }

        var secondColor by rememberSaveable { mutableStateOf(false) }
        val realColor2 by animateColorAsState(
            targetValue = if (secondColor) Color.Blue else Color.Red,
            animationSpec = tween(durationMillis = 1500),// Tiempo de transición
            finishedListener = { activeChangeText = !activeChangeText }
        )

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = !secondColor }) {
            if (activeChangeText) {
                Text(
                    text = "FINNN...",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Animación",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}