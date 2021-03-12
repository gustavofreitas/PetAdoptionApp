package com.example.androiddevchallenge.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.entity.Pet
import com.example.androiddevchallenge.ui.common.CircularImage

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(openDetails: (Pet) -> Unit, model: HomeViewModel = viewModel()) {
    val image = painterResource(R.drawable.cat_funny_face)
    val pets by model.pets.observeAsState(listOf())

    PetCardList(pets = pets) {
        PetCard(it, image, openDetails)
    }
}

@ExperimentalFoundationApi
@Composable
fun PetCardList(
    pets: List<Pet>,
    listItem: @Composable (Pet) -> Unit
) {
    LazyVerticalGrid(
        GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = pets) {
            Box(Modifier.padding(8.dp)) {
                listItem(it)
            }
        }
    }

}

@Composable
fun PetCard(data: Pet, image: Painter, openDetails: (Pet) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { openDetails(data) },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularImage(image)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.name,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun PreviewPetCard() {
    PetCard(data = Pet("Snow"), painterResource(R.drawable.cat_funny_face)) { }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHome() {
    Surface(color = MaterialTheme.colors.surface) {
        HomeScreen(openDetails = { /*TODO*/ })
    }
}