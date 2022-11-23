package com.cursojetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursojetpackcompose.ui.CheckInfo
import com.cursojetpackcompose.ui.theme.CursoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SimpleRecyclerView()
                    //SuperHeroView()
                    //SuperHeroGridView()
                    //SuperHeroWithSpecialControlsView()
                    SuperHeroStickyView()

                    /*TwitterScreen()
                    TwitDivider()
                    TwitterScreen()
                     */
                    /*
                    val myOptions = GetOptions(listOf("Julian", "Ejemplo", "Test"))
                    Column {
                        MyTriStatusCheckBox()
                        myOptions.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                        MyRadioButton()
                    }
                     */
                    //State hoisting
                    /*
                    var selected by rememberSaveable { mutableStateOf("Julian") }

                    MyRadioButtonList(selected) { selected = it }
                    MySpacer(size = 10)
                     */
                    /*
                    /****** START: DIALOGOS *********/
                    var isVisible by rememberSaveable { mutableStateOf(false) }

                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { isVisible = true }) {
                            Text(text = "Mostrar diálogo")
                        }
                        //MyAlertDialog(isVisible, onDismiss = { isVisible = false }, onConfirm = { Log.i("TAG", "Confirmación") })
                        //MySimpleCustomDialog(isVisible, onDismiss = { isVisible = false })
                        //MyCustomDialog(isVisible, onDismiss = { isVisible = false })
                        MyConfirmationDialog(isVisible, onDismiss = { isVisible = false })
                    }
                    /****** END: DIALOGOS *********/
                    */
                    /*
                    //State hoisting la variable se declara en el padre para poder accederla desde más de un hijo si es necesario
                    var myTest by remember { mutableStateOf("JDCJ") }
                    MyTextField(myTest) { myTest = it }
                     */
                }
            }
        }
    }
}

@Composable
fun GetOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus -> status = newStatus}
        )
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un ejmplo")
        }
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
    }
}

@Composable
fun MyRow() {
    /*Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo1")
        Text(text = "Ejemplo2")
        Text(text = "Ejemplo3")
    }*/
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
        contentAlignment = Alignment.Center) {
            Text(text = "Ejemplo1")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red),
            contentAlignment = Alignment.Center) {
                Text(text = "Ejemplo2")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green),
            contentAlignment = Alignment.Center) {
                Text(text = "Ejemplo3")
            }
        }
        MySpacer(size = 50)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
        contentAlignment = Alignment.BottomCenter) {
            Text(text = "Ejemplo4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableStateOf(0) } // remember conserva el valor mientras no se reconstruya la activity
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText , onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Test Label") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.Green
            ),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Text(text = "Hola")
        }
        MySpacer(10)
        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.Green,
                disabledBackgroundColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
        ) {
            Text(text = "Hola")
        }
        MySpacer(10)
        TextButton(
            onClick = {  }
        ) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.base), contentDescription = "Ejemplo",
        alpha = 0.5f//Opacidad
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.base), contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icon",
        tint = Color.Blue
    )
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            MySpacer(size = 10)
            LinearProgressIndicator(color = Color.Red, backgroundColor = Color.Green)
        }
        
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = if (showLoading) "Ocultar loading" else "Mostrar loading")
        }
    }
}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable { mutableStateOf(0.25f) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)
        
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { if (progressStatus < 1) progressStatus += 0.25f }) {
                Text(text = "Incrementar")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { if (progressStatus > 0) progressStatus -= 0.25f }) {
                Text(text = "Reducir")
            }
            Log.i("TAG", "status: $progressStatus")
        }
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(
        checked = state, onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.1f,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f
        )
    )

}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state, onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Cyan,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}
@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checkInfo.selected, onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}
@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton() {
    var selected by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = selected, onClick = { selected = !selected },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.DarkGray
            )
        )
        Text(text = "Ejemplo Radio")
    }
}

@Composable
fun MyRadioButtonList(title: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(
                selected = title == "Julian", onClick = { onItemSelected("Julian") },
            )
            Text(text = "Julian")
        }
        Row() {
            RadioButton(
                selected = title == "David", onClick = { onItemSelected("David") },
            )
            Text(text = "David")
        }
        Row() {
            RadioButton(
                selected = title == "Test", onClick = { onItemSelected("Test") },
            )
            Text(text = "Test")
        }
        Row() {
            RadioButton(
                selected = title == "Hola", onClick = { onItemSelected("Hola") },
            )
            Text(text = "Hola")
        }
    }
}

/**
 * Surface es otro componente similar a Card, pero que ya trae algunos atributos definidos
 */
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.LightGray,
        contentColor = Color.Blue,
        border = BorderStroke(3.dp, Color.Cyan)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Text 1")
            Text(text = "Text 2")
            Text(text = "Text 3")
        }
    }
}

@Composable
fun MyBadgeBox() {
    Row() {
        BadgedBox(
            modifier = Modifier.padding(16.dp),
            badge = {
                Badge(
                    backgroundColor = Color.Blue, contentColor = Color.Yellow
                ) {
                    Text(text = "5")
                }
            }
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        }
    }
}

@Composable
fun MyDivider() {
    Column {
        Text(text = "Hola")

        Divider(
            color = Color.Green
        )

        Text(text = "Mundo")
    }
}

@Composable
fun MyDropdownMenu() {

    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Café", "Natilla", "Fruta")

    Column(Modifier.padding(20.dp)) {
        Row() {
            OutlinedTextField(
                value = selectedText, onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded, onDismissRequest = { expanded = false }
            ) {
                desserts.forEach { dessert ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        selectedText = dessert
                    }) {
                        Text(text = dessert)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CursoJetpackComposeTheme {
        MyDropdownMenu()
    }
}