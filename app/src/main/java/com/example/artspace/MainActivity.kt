package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    var result by remember { mutableStateOf(1) }
    when (result) {
        1 -> ArtSpaceImageWithText(
            artWorkWall = R.drawable.artwall_1, artWorkTitle = R.string.image_1_title,
            artWorkArtist = R.string.image_1_artist, artWorkYear = R.string.image_1_year
        )
        2 -> ArtSpaceImageWithText(
            artWorkWall = R.drawable.artwall_2, artWorkTitle = R.string.image_2_title,
            artWorkArtist = R.string.image_2_artist, artWorkYear = R.string.image_2_year
        )
        3 -> ArtSpaceImageWithText(
            artWorkWall = R.drawable.artwall_3, artWorkTitle = R.string.image_3_title,
            artWorkArtist = R.string.image_3_artist, artWorkYear = R.string.image_3_year
        )
        else -> ArtSpaceImageWithText(
            artWorkWall = R.drawable.artwall_4, artWorkTitle = R.string.image_4_title,
            artWorkArtist = R.string.image_4_artist, artWorkYear = R.string.image_4_year
        )
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(Alignment.Bottom)
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Button(
            onClick = {
                if (result > 1) {
                    result -= 1
                } else {
                    result = (1..4).random()
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .wrapContentWidth(Alignment.Start)
        ) {
            Text(text = stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(30.dp))
        Button(
            onClick = {
                if (result <= 4) {
                    result += 1
                } else {
                    result = 1
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .wrapContentWidth(Alignment.End)
        ) {
            Text(text = stringResource(R.string.next_button))
        }
    }
}

@Composable
fun ArtSpaceImageWithText(
    artWorkWall: Int,
    artWorkTitle: Int,
    artWorkArtist: Int,
    artWorkYear: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .border(
                BorderStroke(4.dp, Color.Gray),
                RectangleShape
            )
            .shadow(elevation = 5.dp)
    ) {
        Image(
            painter = painterResource(id = artWorkWall),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(350.dp)
                .width(300.dp)
                .padding(20.dp)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(bottom = 100.dp)
            .fillMaxWidth()
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentSize(Alignment.BottomCenter)
            .shadow(elevation = 5.dp)
    ) {
        Text(
            text = stringResource(id = artWorkTitle),
            fontSize = 36.sp,
            modifier = Modifier
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = artWorkArtist),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(
                text = stringResource(id = artWorkYear),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}