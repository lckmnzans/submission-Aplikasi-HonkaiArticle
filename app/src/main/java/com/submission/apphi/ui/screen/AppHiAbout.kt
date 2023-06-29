package com.submission.apphi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.submission.apphi.R
import com.submission.apphi.ui.theme.AppHiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHiAbout(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(topBar = { TopBar(navController) }) { innerPadding ->
        ProfileScreen(innerPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun AppHiAboutPreview() {
    AppHiTheme {
        //
    }
}

@Composable
fun ProfileScreen(padding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(padding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Lukman Sanusi",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "lckmnzans@gmail.com",
                fontSize = 20.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    ) {
    TopAppBar(
        title = { Text(text = "About me") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}