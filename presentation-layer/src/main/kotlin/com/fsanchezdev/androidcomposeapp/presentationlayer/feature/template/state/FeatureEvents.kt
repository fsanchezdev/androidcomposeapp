package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state

import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.BaseMviEvent

internal sealed class FeatureUserEvents : BaseMviEvent.User {
    data class OnButtonClicked(val buttonTextGreeting: String) : FeatureUserEvents()
    data object OnNoNetworkRetryClick : FeatureUserEvents()
}

internal sealed class FeatureEffectEvents : BaseMviEvent.Effect {
    data class ShowGreetings(val greeting: String) : FeatureEffectEvents()
}
