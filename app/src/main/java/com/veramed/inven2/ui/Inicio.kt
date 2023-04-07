package com.veramed.inven2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.veramed.repository.ListaRepo
import com.veramed.inven2.ui.BotonIniciarConteo


@Composable
fun pantalla_inicio(navController: NavController) {


    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val itemrepo = ListaRepo()
    val data = itemrepo.getTestData()

    Scaffold(
        scaffoldState = scaffoldState,


        topBar = {  TopAppBar(
            { Row {

            } })
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { 
            FloatingActionButton(onClick = { navController.navigate(route = Screen.DatosIniciales.route) }){
            Text("Nuevo")
        } },
        content = {padding ->
            Column(
                modifier = Modifier
                    .padding(padding)) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        ItemListaHeader()
                    }
                    items(items=data) { art ->
                        ItemListaInv(art)
                    }
                    item {
                        Text("Capturas realizadas ${data.size}")
                    }

                }
            }
        }
    )
}

