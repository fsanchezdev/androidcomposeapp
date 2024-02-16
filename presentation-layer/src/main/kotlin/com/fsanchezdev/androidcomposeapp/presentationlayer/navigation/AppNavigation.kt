package com.fsanchezdev.androidcomposeapp.presentationlayer.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.navigation.FeatureNavigation

@Composable
public fun AppNavigation() {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = FeatureNavigation.ROUTE,
    modifier = Modifier.fillMaxSize(),
    route = "mainGraph"
  ) {
    FeatureNavigation.navGraphBuilder(this)
  }
}
