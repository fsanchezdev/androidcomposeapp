package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state

import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.BaseMviState
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ComposeStateType

public data class FeatureState(
    val stateGreeting: String = "Hello, World!",
    override var type: ComposeStateType = ComposeStateType.Render
) : BaseMviState(type)
