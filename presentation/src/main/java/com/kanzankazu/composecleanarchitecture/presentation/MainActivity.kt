package com.kanzankazu.composecleanarchitecture.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanzankazu.composecleanarchitecture.presentation.R
import com.kanzankazu.composecleanarchitecture.presentation.base.BaseActivityBindingCompose
import com.kanzankazu.composecleanarchitecture.presentation.navigation.ScreenNavigation
import com.kanzankazu.composecleanarchitecture.presentation.screen.listuser.ListUserScreen
import com.kanzankazu.composecleanarchitecture.presentation.screen.splash.SplashScreen
import com.kanzankazu.composecleanarchitecture.presentation.ui.theme.AstroFreelanceAndroidAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityBindingCompose() {

    @Composable
    override fun SetContentCompose() {
        AstroFreelanceAndroidAssignmentTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = ScreenNavigation.Splash.route
            ) {
                composable(ScreenNavigation.Splash.route) {
                    SplashScreen(stringList = listOf(stringResource(id = R.string.label_hello_tester))) {
                        navController.navigate(ScreenNavigation.ListUser.route) {
                            popUpTo(0)
                        }
                    }
                }
                composable(ScreenNavigation.ListUser.route) {
                    ListUserScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(listOf("test"))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListUserScreenPreview() {
    ListUserScreen()
}