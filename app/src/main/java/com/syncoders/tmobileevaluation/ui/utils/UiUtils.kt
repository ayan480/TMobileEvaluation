package com.syncoders.tmobileevaluation.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


object UiUtils {

    fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }


    fun CoroutineScope.showSnackbar(
        snackbarHostState: SnackbarHostState,
        message: String,
        actionLabel: String? = null,
        action: (() -> Unit)? = null
    ) {
        this.launch {
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel
            ).also {
                if (it == androidx.compose.material3.SnackbarResult.ActionPerformed) {
                    action?.invoke()
                }
            }
        }
    }
}
