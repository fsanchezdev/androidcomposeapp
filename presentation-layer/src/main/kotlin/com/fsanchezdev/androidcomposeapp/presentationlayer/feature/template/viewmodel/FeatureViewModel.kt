package com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fsanchezdev.androidcomposeapp.presentationlayer.feature.template.state.FeatureState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class FeatureViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _state =
    MutableStateFlow(FeatureState())
  val state = _state.asStateFlow()

  fun greet(name: String) {
    _state.update {
      it.copy(
        greeting = "Hello, $name"
      )
    }
  }
}
