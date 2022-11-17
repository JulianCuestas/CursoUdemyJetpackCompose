package com.cursojetpackcompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(
    isVisible: Boolean,
    onDismiss:() -> Unit,
    onConfirm:() -> Unit,
) {
    if (isVisible) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Título") },
            text = { Text(text = "Esta es la descripción :)") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            }
        )
    }
}

@Composable
fun MySimpleCustomDialog(
    isVisible: Boolean,
    onDismiss:() -> Unit,
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            )
        ) {
            Column(
                Modifier
                    .background(Color.LightGray)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Diálogo personalizado")
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    isVisible: Boolean,
    onDismiss:() -> Unit,
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            )
        ) {
            Column(
                Modifier
                    .background(Color.LightGray)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(title = "Set backup account")
                AccountItem(email = "test@test.com", drawable = R.drawable.base)
                AccountItem(email = "example@example.com", drawable = R.drawable.base)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.plus)
            }
        }
    }
}

@Composable
fun TitleDialog(title: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = title, fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = drawable), contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyConfirmationDialog(
    isVisible: Boolean,
    onDismiss:() -> Unit,
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            )
        ) {
            Column(
                Modifier
                    .background(Color.LightGray)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(title = "Phone ringtone", modifier = Modifier.padding(bottom = 24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.Black)
                var status by rememberSaveable { mutableStateOf("") }
                MyRadioButtonList(title = status, onItemSelected = { status = it })
                Divider(Modifier.fillMaxWidth(), color = Color.Black)
                Row(
                    Modifier.align(Alignment.End).padding(top = 24.dp)
                ) {
                    TextButton(onClick = {  }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}