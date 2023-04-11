package com.veramed.util

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.io.IOException


fun imageAnalyzer(context:Context,uri:Uri) {

    Log.d("INVEN2","Archivo "+uri.path)

    //Imputval image: InputImage
   //image = InputImage.fromFilePath(context, uri)
    try {
        val image = InputImage.fromFilePath(context, uri)

        val scanner = BarcodeScanning.getClient()

        val result = scanner.process(image)
            .addOnSuccessListener { barcodes ->
                for (barcode in barcodes) {
                    val bounds = barcode.boundingBox
                    val corners = barcode.cornerPoints

                    val rawValue = barcode.rawValue
                    Toast.makeText(context,
                        "Codigo de barra: $rawValue",
                        Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(context,
                    "Lectura Fallida",
                    Toast.LENGTH_SHORT).show()
            }

    } catch (e: IOException) {
        e.printStackTrace()
    }




}
