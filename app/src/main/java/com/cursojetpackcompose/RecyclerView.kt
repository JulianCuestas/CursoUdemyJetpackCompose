package com.cursojetpackcompose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursojetpackcompose.model.SuperHero


@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Julian", "Test", "Jetpack", "Compose")
    LazyColumn {

        item {
            Text(text = "Header")
            Divider(Modifier.height(0.5.dp))
        }

        item { Text(text = "Primer item") }

        items(7) {
            Text(text = "Item $it")
        }

        items(myList) {
            Text(text = "Hola $it")
        }

        item {
            Divider(Modifier.height(0.5.dp))
            Text(text = "Footer")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),  // GridCells.Adaptative(100.dp) Asigna mínimo 100dp a cada item hasta adaptarlo
        content = {
            items(getSuperHeroes()) {
                DrawItemHero(superHero = it) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        },
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    )
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(8.dp)// Separador entre items
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)// Separador entre items
    ) {
        items(getSuperHeroes()) {
            DrawItemHero(superHero = it) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun DrawItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable {
                onItemSelected(superHero)
            }
    ) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = superHero.superHeroName,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop// Permite que tome el total del ancho y adapta la imagen para q se vea OK
            )
            Text(text = superHero.superHeroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(
            "Spiderman",
            "Petter Parker",
            "Marvel",
            R.drawable.spiderman
        ),
        SuperHero(
            "Wolverine",
            "James Howlett",
            "Marvel",
            R.drawable.logan
        ),
        SuperHero(
            "Batman",
            "Bruce Wayne",
            "DC",
            R.drawable.batman
        ),
        SuperHero(
            "Thor",
            "Thor Odinson",
            "Marvel",
            R.drawable.thor
        ),
        SuperHero(
            "Flash",
            "Jay Garrick",
            "DC",
            R.drawable.flash
        ),
        SuperHero(
            "Green Lantern",
            "Alan Scott",
            "DC",
            R.drawable.green_lantern
        ),
        SuperHero(
            "Wonder Woman",
            "Princess Diana",
            "DC",
            R.drawable.wonder_woman
        )
    )
}

