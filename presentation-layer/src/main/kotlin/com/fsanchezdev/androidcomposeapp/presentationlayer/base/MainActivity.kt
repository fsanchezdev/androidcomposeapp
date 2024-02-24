package com.fsanchezdev.androidcomposeapp.presentationlayer.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ui.theme.AppTheme
import com.fsanchezdev.androidcomposeapp.presentationlayer.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            ChangeSystemBarsTheme(!isSystemInDarkTheme())
            AppTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    private fun ChangeSystemBarsTheme(lightTheme: Boolean) {
        val barColor = MaterialTheme.colorScheme.background.toArgb()
        DisposableEffect(lightTheme) {
            if (lightTheme) {
                this@MainActivity.enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(
                        barColor,
                        barColor
                    ),
                    navigationBarStyle = SystemBarStyle.light(
                        barColor,
                        barColor
                    )
                )
            } else {
                this@MainActivity.enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        barColor
                    ),
                    navigationBarStyle = SystemBarStyle.dark(
                        barColor
                    )
                )
            }
            onDispose {}
        }
    }
}
