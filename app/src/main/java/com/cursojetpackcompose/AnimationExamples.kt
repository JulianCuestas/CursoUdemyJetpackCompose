package com.cursojetpackcompose

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SensorDoor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random.Default.nextInt

@Composable
fun Animations() {
    Column() {

        var activeChangeText  by rememberSaveable { mutableStateOf(false) }

        var secondColor by rememberSaveable { mutableStateOf(false) }
        val realColor2 by animateColorAsState(
            targetValue = if (secondColor) Color.Blue else Color.Red,
            animationSpec = tween(durationMillis = 500),// Tiempo de transición
            finishedListener = { activeChangeText = !activeChangeText }// acción ejecutable al finalizar la aanimación
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

        Spacer(modifier = Modifier.height(30.dp))
        SizeAnimation()

        Spacer(modifier = Modifier.height(30.dp))
        VisibilityAnimation()

        Spacer(modifier = Modifier.height(30.dp))
        CrossfadeExampleAnimation()
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size = animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),// Tiempo de transición
    )
    Box(modifier = Modifier
        .size(size.value)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize }) {

    }
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(true) }
    Button(onClick = { isVisible = !isVisible }) {
        Text(text = "Mostrar/Ocultar")
    }
    Spacer(modifier = Modifier.height(15.dp))
    AnimatedVisibility (
        visible = isVisible,
        enter = slideInHorizontally(),
        exit = slideOutHorizontally()
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
        ) {}
    }
}

@Composable
fun CrossfadeExampleAnimation() {
    var myComponentType: ComponentType by remember { mutableStateOf(ComponentType.Text) }

    Button(onClick = { myComponentType = getComponentTypeRandom() }) {
        Text(text = "Cambiar componente")
    }
    
    Crossfade(targetState = myComponentType) {
        when (it) {
            ComponentType.Image -> Icon(imageVector = Icons.Default.SensorDoor, contentDescription = "")
            ComponentType.Text -> Text(text = "Componente Text")
            ComponentType.Box -> Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Magenta))
            ComponentType.Error -> Text(text = "ERROR", color = Color.Red)
        }
    }

}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from =0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}