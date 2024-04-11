package com.fsanchezdev.androidcomposeapp.presentationlayer

import arrow.core.Either
import com.fsanchezdev.androidcomposeapp.domainlayer.base.DomainLayerContract
import com.fsanchezdev.androidcomposeapp.domainlayer.usecase.GetPlaceholderImageUseCase
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureEffectEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureUserEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel.FeatureViewModel
import io.mockk.coEvery
import io.mockk.mockk
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
internal class FeatureViewModelTest {

    private lateinit var viewModel: FeatureViewModel
    private lateinit var mockPlaceHolderRepository: DomainLayerContract.Data.PlaceHolderRepository
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher) // Set the main dispatcher to the test dispatcher
        mockPlaceHolderRepository = mockk(relaxed = true) // Initialize the mock

        // Prepare the mock to return a specific result
        coEvery { mockPlaceHolderRepository.getPlaceHolderImage() } returns Either.Right(
            byteArrayOf()
        )

        // Initialize the ViewModel with the mocked UseCase and Repository
        viewModel = FeatureViewModel(GetPlaceholderImageUseCase(mockPlaceHolderRepository))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the main dispatcher
    }

    @Test
    fun `when OnButtonClicked event is sent, ShowGreetings effect is emitted`() = runTest {
        val events = mutableListOf<FeatureEffectEvents>()

        // Start collecting effects in a coroutine
        val collectJob = launch(testDispatcher) {
            viewModel.effect.collect { events.add(it) }
        }

        // Action: send the event
        viewModel.onEvent(FeatureUserEvents.OnButtonClicked("Hi, Test!"))

        // Wait for the coroutines to be processed
        advanceUntilIdle()

        // Verify that the expected effect has been emitted
        assertTrue(
            events.contains(FeatureEffectEvents.ShowGreetings("Hi, Test!"))
        )

        collectJob.cancel() // Cancel the effect collection
    }
}
