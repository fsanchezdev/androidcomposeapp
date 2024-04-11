package com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose

internal sealed class ComposeStateType {
    data object Loading : ComposeStateType()
    data object Render : ComposeStateType()
}
