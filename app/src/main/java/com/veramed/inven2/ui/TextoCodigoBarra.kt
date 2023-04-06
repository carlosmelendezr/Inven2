package com.veramed.inven2.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextoCodigoBarra() {
    val mContext = LocalContext.current
    val maxLen = 14
    Row () {
        var texto by remember { mutableStateOf("") }
        TextField(

            value = texto,
            placeholder = { Text("Código de Barra") },
            onValueChange = { newText ->
                if (newText.length <= maxLen)
                    texto = newText else
                    Toast.makeText(mContext,
                        "La longitud no puede ser mayor a $maxLen",
                        Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.background(Color.White),
            textStyle = TextStyle(Color.Black) ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true

        )
    }

}