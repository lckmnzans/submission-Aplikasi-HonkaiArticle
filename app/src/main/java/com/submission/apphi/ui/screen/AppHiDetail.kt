package com.submission.apphi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import java.net.URLDecoder

@Composable
fun AppHiDetail(name: String, ranking: String, imgUrl: String, desc: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    LoadImageFromUrl(url = URLDecoder.decode(imgUrl, "UTF-8"))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = ranking,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                    Text(
                        text = name.uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = URLDecoder.decode(desc, "UTF-8"),
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}


@Composable
fun LoadImageFromUrl(url: String) {
    val painter = rememberImagePainter(
        data = url,
    )

    Box(modifier = Modifier.aspectRatio(0.7f)) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
