package com.veramed.inven2.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun TextoDescripcion() {
    Row () {
        var texto by remember { mutableStateOf("") }
        OutlinedTextField(
            value = texto,
            onValueChange = { newText ->
                texto = newText
            },
            label = {
                Text("Descripción")
            },
            singleLine = false

        )
    }

}