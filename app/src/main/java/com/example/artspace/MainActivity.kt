package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
    ArtSpaceImageWithText(
        artWorkWall = R.drawable.artwall_1,
        artWorkTitle = R.string.image_1_title,
        artWorkArtist = R.string.image_1_artist,
        artWorkYear = R.string.image_1_year
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .wrapContentHeight(Alignment.Bottom)
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(15.dp)
                .wrapContentWidth(Alignment.Start)
        ) {
            Text(text = stringResource(R.string.previous_button))
        }
        Spacer(modifier = Modifier.width(30.dp))
        Button(
            onClick = { /*TODO*/ },
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
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Image(
            painter = painterResource(id = artWorkWall),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(350.dp)
                .wrapContentSize(Alignment.Center)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(bottom = 100.dp)
            .shadow(shape = RectangleShape, elevation = 2.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Text(
            text = stringResource(id = artWorkTitle),
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = artWorkArtist),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = artWorkYear),
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

/*fun performAction() {

}*/

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}