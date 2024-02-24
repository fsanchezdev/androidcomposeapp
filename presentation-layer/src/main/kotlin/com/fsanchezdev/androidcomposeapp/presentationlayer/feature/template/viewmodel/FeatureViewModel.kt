package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel

import androidx.lifecycle.viewModelScope
import com.fsanchezdev.androidcomposeapp.domainlayer.FailureBo
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.BaseMviViewModel
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ComposeStateType
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureEffectEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureState
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureStateOld
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureUserEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class FeatureViewModel @Inject constructor() : BaseMviViewModel<
    FeatureUserEvents,
    FeatureEffectEvents,
    FeatureState
    >(
    initialState = FeatureState()
) {

    private val _state =
        MutableStateFlow(FeatureStateOld())
    val state = _state.asStateFlow()

    fun greet(name: String) {
        _state.update {
            it.copy(
                greeting = "Hello, $name"
            )
        }
    }

    override fun onEvent(event: FeatureUserEvents) {
        when (event) {
            is FeatureUserEvents.OnButtonClicked -> sendEffect {
                FeatureEffectEvents.ShowGreetings(event.buttonTextGreeting)
            }
        }
    }

    private fun handleError(error: FailureBo) {
        emitState { copy(type = ComposeStateType.Render) }
        viewModelScope.launchFailure(error)
    }
}
