package com.veramed.inven2.ui

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.veramed.inven2.MainActivity
import com.veramed.util.Barcode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.veramed.inven2.ComposeFileProvider
import com.veramed.util.getCamImageUri
import com.veramed.util.imageAnalyzer


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

    var hasImage by remember {
        mutableStateOf(false)
    }
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var bitmap:Bitmap


    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    /*val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            hasImage = success
        }
    )*/

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { success ->
           //bitmap = success
        }
    )

    val mContext = LocalContext.current
    IconButton(
        onClick = {
            val uri =  ComposeFileProvider.getImageUri(mContext)


            imageUri = uri
            //cameraLauncher.launch(uri)
            //bitmap = cameraLauncher.launch()
            imageAnalyzer(mContext,uri)

        }
    ) {
        Icon(Icons.Rounded.Camera,contentDescription = "Scanear con la cámara" )
    }
}

