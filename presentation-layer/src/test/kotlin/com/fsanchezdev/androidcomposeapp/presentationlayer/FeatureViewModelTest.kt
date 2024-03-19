package com.fsanchezdev.androidcomposeapp.presentationlayer

import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureEffectEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureUserEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel.FeatureViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FeatureViewModelTest {
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        // Set the TestDispatcher
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the Main Dispatcher
        Dispatchers.resetMain()
    }

    @Test
    fun `when OnButtonClicked event is sent, ShowGreetings effect is emitted`() = runTest {
        val viewModel = FeatureViewModel()
        val events = mutableListOf<FeatureEffectEvents>()

        // Start a coroutine to collect effects
        val collectJob = launch {
            viewModel.effect.collect { events.add(it) }
        }

        // Action
        viewModel.onEvent(FeatureUserEvents.OnButtonClicked("Hi, Test!"))

        // Wait a moment for the event to be processed and the effect to be emitted
        advanceUntilIdle()

        // Assertion
        assertTrue(events.contains(FeatureEffectEvents.ShowGreetings("Hi, Test!")))

        // Cancel the collection coroutine to avoid leaving uncompleted coroutines
        collectJob.cancel()
    }
}
