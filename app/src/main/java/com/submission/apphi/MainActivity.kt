package com.submission.apphi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.submission.apphi.ui.screen.AppHiAbout
import com.submission.apphi.ui.screen.AppHiDetail
import com.submission.apphi.ui.screen.AppHiMain
import com.submission.apphi.ui.theme.AppHiTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppHiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            AppHiMain(navController = navController)
                        }
                        composable("about") {
                            AppHiAbout(navController = navController)
                        }
                        composable(
                            "detail/{name}/{ranking}/{imgUrl}/{desc}",
                            arguments = listOf(
                                navArgument("name") { type = NavType.StringType },
                                navArgument("ranking") { type = NavType.StringType },
                                navArgument("imgUrl") { type = NavType.StringType },
                                navArgument("desc") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            val ranking = backStackEntry.arguments?.getString("ranking") ?: ""
                            val imgUrl = backStackEntry.arguments?.getString("imgUrl") ?: ""
                            val desc = backStackEntry.arguments?.getString("desc") ?: ""
                            AppHiDetail(name, ranking, imgUrl, desc)
                        }
                    }
                }
            }
        }
    }
}