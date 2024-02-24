package com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose

public sealed class ComposeStateType {
    public data object Loading : ComposeStateType()
    public data object Render : ComposeStateType()
}
