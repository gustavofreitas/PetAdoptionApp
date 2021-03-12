package com.example.androiddevchallenge.ui.detail

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.entity.Pet
import com.example.androiddevchallenge.ui.common.CircularImage
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import java.util.*

@Composable
fun DetailScreen(data: Pet, navigateBack: () -> Unit) {
    Column {

        DetailTopBar(petName = data.name, navigateBack = navigateBack)

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularImage(imageRes = data.image)
            Spacer(modifier = Modifier.height(8.dp))
            Highlights(data = data)
        }
    }
}

@Composable
fun DetailTopBar(petName: String, navigateBack: () -> Unit) {
    TopAppBar(title = { Text(petName) },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(imageVector = Icons.Default.ArrowBack, null)
            }
        })
}

@Composable
fun Highlights(data: Pet) {
    Box {
        val highlights = mutableListOf<String>()
        data.color?.let { highlights.add(it) }
        data.sex.let { highlights.add(stringResource(id = it)) }
        Text(highlights.joinToString(" + ").toUpperCase(Locale.ROOT))
    }
}

@Composable
fun DetailInfo(@StringRes header: Int, @StringRes content: Int) {
    DetailInfo(header, stringResource(id = content))
}

@Composable
fun DetailInfo(@StringRes header: Int, content: String) {
    Column(Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = header), style = typography.caption)
        Text( text = content, style = typography.body1)
    }
}

@Preview
@Composable
fun DetailInfoPreview(){
    MyTheme {
        Surface {
            DetailInfo(header = R.string.label_pedigree, content = "American Short Hair" )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    MyTheme {
        Surface {
            DetailScreen(Pet("Sofia", pedigree = "undefined", sex=R.string.female)) {
                /*TODO*/
            }
        }
    }
}