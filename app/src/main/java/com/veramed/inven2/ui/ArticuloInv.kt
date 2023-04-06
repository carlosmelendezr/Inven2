package com.veramed.inven2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veramed.model.Articulo
import com.veramed.repository.ItemRepo


@Composable
fun ArticuloInv(articulo: Articulo) {
    Row (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Text (
            text = "${articulo.barra}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(2f)
        )
        Text (
            text = "${articulo.sap}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier =Modifier.weight(2f)
        )
        Text (
            text = articulo.descripcion,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            modifier =Modifier.weight(4f)
        )

        Text (
            text = articulo.cant.toString(),
            color = Color.Blue,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

    }
}