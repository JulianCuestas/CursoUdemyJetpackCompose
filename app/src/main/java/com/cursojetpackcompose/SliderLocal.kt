package com.cursojetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.cursojetpackcompose.ui.theme.CursoJetpackComposeTheme

@Composable
fun MyBasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        var completeValue by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentRange by remember { mutableStateOf(0f..10f) }
        RangeSlider(
            values = currentRange, onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "Valor inferior ${currentRange.start}")
        Text(text = "Valor superior ${currentRange.endInclusive}")
    }
}

@Preview(showBackground = true)
@Composable
fun MySliderPreview() {
    CursoJetpackComposeTheme {
        MyRangeSlider()
    }
}
