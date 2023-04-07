package com.veramed.inven2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp



@Composable
fun ItemListaHeader() {
    Row (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Text (
            text = "ID",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f)
        )
        Text (
            text = "Nombre",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(2f)
        )
        Text (
            text = "Descripción",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(2f)
        )


    }
}