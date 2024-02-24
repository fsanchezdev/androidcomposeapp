package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fsanchezdev.androidcomposeapp.presentationlayer.R
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureEffectEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureState
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureStateOld
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureUserEvents
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel.FeatureViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

@Composable
public fun FeatureScreen() {
    val vm = if (LocalInspectionMode.current) {
        FeatureViewModel()
    } else {
        hiltViewModel<FeatureViewModel>()
    }
    val stateOld by vm.state.collectAsStateWithLifecycle()
    val state: FeatureState by vm.screenState

    // TODO handle error state here?

    FeatureScreen(
        state = stateOld,
        state2 = state,
        greet = vm::greet,
        onEvent = vm::onEvent,
        effect = vm.effect
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun FeatureScreen(
    state: FeatureStateOld,
    greet: (name: String) -> Unit,
    state2: FeatureState,
    onEvent: (FeatureUserEvents) -> Unit,
    effect: Flow<FeatureEffectEvents>
) {
    var fieldText: String by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = "") {
        effect.onEach { effect ->
            when (effect) {
                is FeatureEffectEvents.ShowGreetings -> {
                    fieldText = "from effect ${effect.greeting}"
                    // used for check the effect, in this case we could use variable fieldtext only
                }
            }
        }.collect()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(R.string.greeter)) })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by rememberSaveable { mutableStateOf("") }
            Text(text = stringResource(R.string.insert_name))
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.semantics {
                    contentDescription = "Insert name"
                }
            )
            Button(
                onClick = { // greet(text)
                    onEvent(FeatureUserEvents.OnButtonClicked(text))
                    greet.toString()
                    state.greeting
                    state2.stateGreeting
                },
                modifier = Modifier.semantics {
                    contentDescription = "Greet button"
                }
            ) {
                Text(text = stringResource(R.string.greet))
            }
            Text(
                text = fieldText,
                modifier = Modifier.semantics {
                    contentDescription = "Greeting"
                }
            )

            // Image(painter = , contentDescription = )
        }
    }
}

@Preview(name = "Day mode")
@Preview(name = "Night mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    FeatureScreen(
        state = FeatureStateOld(),
        state2 = FeatureState(),
        greet = {},
        onEvent = {},
        effect = flowOf()
    )
}
