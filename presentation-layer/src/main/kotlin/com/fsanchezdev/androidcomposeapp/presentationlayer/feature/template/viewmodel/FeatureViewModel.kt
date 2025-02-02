package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel

import androidx.lifecycle.viewModelScope
import com.fsanchezdev.androidcomposeapp.domainlayer.FailureBo
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.BaseMviViewModel
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ComposeStateType
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureEffectEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureState
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureUserEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class FeatureViewModel @Inject constructor() : BaseMviViewModel<
    FeatureUserEvents,
    FeatureEffectEvents,
    FeatureState
    >(
    initialState = FeatureState()
) {
    override fun onEvent(event: FeatureUserEvents) {
        when (event) {
            is FeatureUserEvents.OnButtonClicked -> sendEffect {
                FeatureEffectEvents.ShowGreetings(event.buttonTextGreeting)
            }

            FeatureUserEvents.OnNoNetworkRetryClick -> {}
        }
    }

    private fun handleError(error: FailureBo) {
        emitState { copy(type = ComposeStateType.Render) }
        viewModelScope.launchFailure(error)
    }
}
