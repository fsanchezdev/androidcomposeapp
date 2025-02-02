package com.fsanchezdev.androidcomposeapp.presentationlayer

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureState
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel.FeatureViewModel
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class FeatureViewModelTest {

  @Test
  fun `greets the person with their name`() = runTest {
    val vm =
      FeatureViewModel(SavedStateHandle())
    vm.state.test {
      assertEquals(FeatureState(), awaitItem())
      vm.greet("Mario")
      assertEquals(
        FeatureState(greeting = "Hello, Mario"),
        awaitItem()
      )
    }
  }
}
