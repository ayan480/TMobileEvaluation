package com.syncoders.tmobileevaluation.ui.screens.auth.view.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black


@Composable
fun TransparentTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    isPasswordField: Boolean = true,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    maxLine: Int = 1,
    imeAction: ImeAction = ImeAction.Next,
    errorMessage: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = errorMessage != null,

    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = keyboardType,
        imeAction = imeAction
    ),
    keyboardActions: KeyboardActions = KeyboardActions(
    ),
    interactionSource: MutableInteractionSource? = null,
) {
    // Determine if the field has an error
    val hasError = errorMessage != null

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = singleLine,
            maxLines = maxLine,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            prefix = prefix,
            suffix = suffix,
            leadingIcon = leadingIcon,
            supportingText = supportingText,
            label = {
                Text(
                    label,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Black)
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = if (hasError) Color.Red else Color.DarkGray,
                unfocusedIndicatorColor = if (hasError) Color.Red else Color.DarkGray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = if (hasError) Color.Red else Color.Black
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = trailingIcon,
            isError = hasError, // Highlight the field if there's an error
            visualTransformation = visualTransformation,
            interactionSource = interactionSource
        )

        // Show the error message if it exists
        if (hasError && !errorMessage.isNullOrEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
    }
}
