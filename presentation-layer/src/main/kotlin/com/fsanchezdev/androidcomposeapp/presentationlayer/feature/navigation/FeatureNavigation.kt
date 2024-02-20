package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.composables.FeatureScreen

public object FeatureNavigation {
    public const val ROUTE: String = "feature"

    public fun navGraphBuilder(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = ROUTE
        ) {
            FeatureScreen()
        }
    }

    public fun navigate(navController: NavController) {
        navController.navigate(ROUTE)
    }
}
