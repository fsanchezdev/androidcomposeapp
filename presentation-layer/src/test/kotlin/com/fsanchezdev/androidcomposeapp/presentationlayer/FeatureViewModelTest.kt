package com.fsanchezdev.androidcomposeapp.presentationlayer

import app.cash.turbine.test
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureStateOld
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel.FeatureViewModel
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class FeatureViewModelTest {

    @Test
    fun `greets the person with their name`() = runTest {
        val vm =
            FeatureViewModel()
        vm.state.test {
            assertEquals(FeatureStateOld(), awaitItem())
            vm.greet("Mario")
            assertEquals(
                FeatureStateOld(greeting = "Hello, Mario"),
                awaitItem()
            )
        }
    }
}
