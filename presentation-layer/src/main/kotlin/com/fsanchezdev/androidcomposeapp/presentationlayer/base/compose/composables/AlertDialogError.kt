package com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ui.theme.eightDp
import com.fsanchezdev.androidcomposeapp.presentationlayer.base.compose.ui.theme.zeroDp

@Composable
public fun AlertDialogError(title: String, message: String, onConfirm: (() -> Unit)? = null) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = {
                Text(text = title)
            },
            text = {
                Text(
                    message
                )
            },
            confirmButton = {
                onConfirm?.let { onConfirm ->
                    Button(
                        onClick = {
                            onConfirm.invoke()
                            openDialog.value = false
                        }
                    ) {
                        Text("OK")
                    }
                }
            },
            shape = RoundedCornerShape(
                topStart = zeroDp,
                topEnd = zeroDp,
                bottomStart = eightDp,
                bottomEnd = eightDp
            )
        )
    }
}

@Preview
@Composable
public fun AlertDialogErrorPreview() {
    AlertDialogError(
        title = "Error genérico",
        message = "Parece que el código que has introducido no es correcto. Inténtalo de nuevo."
    )
}

@Preview
@Composable
public fun AlertDialogButtonErrorPreview() {
    AlertDialogError(
        title = "Error genérico",
        message = "Parece que el código que has introducido no es correcto. Inténtalo de nuevo.",
        onConfirm = { }
    )
}
