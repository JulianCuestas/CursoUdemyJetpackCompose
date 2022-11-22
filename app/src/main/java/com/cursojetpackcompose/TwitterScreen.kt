package com.cursojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursojetpackcompose.ui.theme.CursoJetpackComposeTheme

@Composable
fun TwitterScreen() {
    var isSelectedChat by remember { mutableStateOf(false) }
    var isSelectedRt by remember { mutableStateOf(false) }
    var isSelectedLike by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF161D26))
            .padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Image profile",
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            Row(Modifier.fillMaxWidth()) {
                TextTitle(title = "Julian DCJ", Modifier.padding(end = 8.dp))
                DefaultText(title = "@JulianDCJ", Modifier.padding(end = 8.dp))
                DefaultText(title = "4h", Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painterResource(id = R.drawable.ic_dots), contentDescription = "",
                    tint = Color.White
                )
            }
            TextBody(
                title = "Esto es una frase larga del twit" +
                        "Esto es una frase larga del twit" +
                        "Esto es una frase larga del twit" +
                        "Esto es una frase larga del twit" +
                        "Esto es una frase larga del twit",
                Modifier.padding(bottom = 12.dp)
            )

            Image(
                painterResource(id = R.drawable.profile), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )

            Row(Modifier.padding(top = 16.dp)) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    UnselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat), contentDescription = "",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    SelectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat_filled), contentDescription = "",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    isSelected = isSelectedChat,
                    {
                        isSelectedChat = !isSelectedChat
                    }
                )

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    UnselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt), contentDescription = "",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    SelectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt), contentDescription = "",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = isSelectedRt,
                    {
                        isSelectedRt = !isSelectedRt
                    }
                )

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    UnselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like), contentDescription = "",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    SelectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like_filled), contentDescription = "",
                            tint = Color(0xFFFF0000)
                        )
                    },
                    isSelected = isSelectedLike,
                    {
                        isSelectedLike = !isSelectedLike
                    }
                )
            }
        }
    }
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun TextBody(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, modifier = modifier)
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    UnselectedIcon: @Composable () -> Unit,
    SelectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        
        if(isSelected) {
           SelectedIcon()
        } else {
           UnselectedIcon()
        }
        
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(4.dp)
        )
        
    }
}

@Composable
fun TwitDivider() {
    Divider(
        Modifier.padding(4.dp).height(0.5.dp).fillMaxWidth(),
        color = Color(0xFF7E8B98)
    )
}

@Preview
@Composable
fun TwitterPreview() {
    CursoJetpackComposeTheme {
        TwitterScreen()
    }
}