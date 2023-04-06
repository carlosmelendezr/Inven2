package com.veramed.inven2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.veramed.inven2.ui.SetupNavGraph
import com.veramed.inven2.ui.pantalla_datos
import com.veramed.inven2.ui.pantalla_inicio
import com.veramed.inven2.ui.theme.Inven2Theme

class MainActivity : ComponentActivity() {

    lateinit var navCont : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inven2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navCont = rememberNavController()
                    SetupNavGraph(navController = navCont)
                }
            }
        }
    }
}

@Preview
@Composable
fun CargarPantallas() {
    //pantalla_inicio();
    pantalla_datos()
}

