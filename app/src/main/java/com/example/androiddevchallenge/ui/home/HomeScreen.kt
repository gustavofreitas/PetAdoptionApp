package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
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

@ExperimentalFoundationApi
@Composable
fun HomeScreen(openDetails: (String) -> Unit, model: HomeViewModel = viewModel()) {
   val listState = rememberLazyListState()
    val image = painterResource(R.drawable.cat_funny_face)

    val pets by model.pets.observeAsState(listOf())

    LazyVerticalGrid(
        GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(8.dp),
        state = listState,
    ) {
        items(items = pets) {
            Box(Modifier.padding(8.dp)) {
                PetCard(petName = it, image, openDetails)
            }
        }
    }

}

@Composable
fun PetCard(petName: String, image: Painter, openDetails: (String) -> Unit) {
    Card(
        Modifier
            .clickable { openDetails(petName) },
        elevation = 4.dp
    ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = image, null)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = petName,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
    }
}

@Preview
@Composable
fun PreviewPetCard() {
    PetCard(petName = "Snow", painterResource(R.drawable.cat_funny_face)) { }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHome() {
    HomeScreen(openDetails = { /*TODO*/ })
}