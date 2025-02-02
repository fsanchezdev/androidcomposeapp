package com.fsanchezdev.androidcomposeapp.presentationlayer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.navigation.FeatureNavigation

@Preview(showBackground = true)
@Composable
public fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = FeatureNavigation.ROUTE,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            route = "mainGraph"
        ) {
            FeatureNavigation.navGraphBuilder(this)
        }
    }
}
