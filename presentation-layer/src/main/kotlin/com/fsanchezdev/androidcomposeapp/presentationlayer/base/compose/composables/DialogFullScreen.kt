package com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fsanchezdev.androidcomposeapp.presentationlayer.R

@Composable
public fun DialogFullScreen(isDisplayed: Boolean, onEvent: () -> Unit) {
    val context = LocalContext.current
    if (isDisplayed) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            event.changes.forEach { it.consume() }
                        }
                    }
                }

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.ic_mobile_photo),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                )

                Text(
                    text = context.getString(R.string.no_network_message),
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    text = context.getString(R.string.no_network_retry),
                    modifier = Modifier
                        .clickable {
                            onEvent.invoke()
                            println("click retry")
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
public fun DialogFullScreenPreview() {
    DialogFullScreen(isDisplayed = true, onEvent = {})
}
