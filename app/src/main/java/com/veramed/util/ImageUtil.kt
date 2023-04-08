package com.veramed.util

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun getCamImageUri(context: Context): Uri? {

    val authority = context.packageName + ".fileprovider"
    var uri: Uri? = null
    val file = createImageFile(context)
    try {
        uri = FileProvider.getUriForFile(context, authority, file)
    } catch (e: Exception) {
        Log.e(ContentValues.TAG, "Error: ${e.message}")
    }
    return uri
}

fun createImageFile(context: Context) : File {
    val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(
        "Camtest_Image_${timestamp}",
        ".jpg",
        imageDirectory
    )
}