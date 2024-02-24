package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state

import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.BaseMviEvent

public sealed class FeatureUserEvents : BaseMviEvent.User {
    public data class OnButtonClicked(val buttonTextGreeting: String) : FeatureUserEvents()
    // public data class ShowGreetings(val greeting: String) : FeatureUserEvents()
}

public sealed class FeatureEffectEvents : BaseMviEvent.Effect {
    public data class ShowGreetings(val greeting: String) : FeatureEffectEvents()
}
