package com.veramed.inven2.ui


import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veramed.repository.ItemRepo

@Preview(showBackground = true)
@Composable
fun pantalla_datos() {


    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val itemrepo = ItemRepo()
    val data = itemrepo.getTestData()

    Scaffold(
        scaffoldState = scaffoldState,
        //drawerContent = { Text("Contando")},

        topBar = {  TopAppBar(
            { Row {
                BotonEscanear()
                TextoCodigoBarra()
                Spacer(modifier = Modifier.width(25.dp))
                TextoCantidad()
            } })},

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("Guardar")
        } },
        content = {padding ->
            Column(
                modifier = Modifier
                    .padding(padding)) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        ArticulosHeader()
                    }
                    items(items=data) { art ->
                        ArticuloInv(articulo = art )
                    }
                    item {
                        Text("Articulos escaneados ${data.size}")
                    }

                }
            }}
    )
}