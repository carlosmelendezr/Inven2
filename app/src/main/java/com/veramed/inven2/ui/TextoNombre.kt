package com.veramed.inven2.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TextoNombreUsuario() {
    Row () {
        var nombre by remember { mutableStateOf("") }
        OutlinedTextField(
            //modifier = Modifier.width(150.dp),
            value = nombre,
            onValueChange = { newText ->
                nombre = newText
            },

            label = {
                Text("Nombre del responsable")
            },
            singleLine = true,

            )
    }

}