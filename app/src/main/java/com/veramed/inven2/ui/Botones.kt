package com.veramed.inven2.ui

import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@Composable
fun BotonIniciarConteo(
    navController: NavController) {
    Button(
        onClick = { navController.navigate(route = Screen.CargaDatos.route) }) {
        Text("Iniciar Conteo")
    }
}

@Preview
@Composable
fun BotonEscanear(){
    IconButton(
        onClick = { }
    ) {
        Icon(Icons.Rounded.Add,contentDescription = "Scanear con la cámara" )
    }
}