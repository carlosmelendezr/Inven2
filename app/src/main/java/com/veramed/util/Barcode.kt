package com.veramed.util

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.startActivityForResult

import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.common.Barcode
import com.veramed.inven2.ComposeFileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class Barcode {

    private var imageCapture: ImageCapture? = null

    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    fun ScanBarCode() {

        val options = BarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                Barcode.FORMAT_EAN_13,
                Barcode.FORMAT_UPC_A).
                enableAllPotentialBarcodes()
            .build()


    }


    @Composable
    fun ImagePicker(
    ) {
        var hasImage by remember {
            mutableStateOf(false)
        }
        var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }


        val imagePicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
            onResult = { uri ->
                hasImage = uri != null
                imageUri = uri
            }
        )

        val cameraLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicture(),
            onResult = { success ->
                hasImage = success
            }
        )

        val context = LocalContext.current
        //val uri = getCamImageUri(context)
        val uri =  ComposeFileProvider.getImageUri(context)
        imageUri = uri
        cameraLauncher.launch(uri)

    }
        fun getCamImageUri(context: Context): Uri? {
            var uri: Uri? = null
            val file = createImageFile(context)
            try {
                uri = FileProvider.getUriForFile(context, "com.testsoft.camtest.fileprovider", file)
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


    /*fun takePhoto(mContext:Context) {

       Log.d(TAG,"Intentando iniciar camara")

           // Get a stable reference of the modifiable image capture use case
        val imageCapture = imageCapture ?: return
        val contentResolver = mContext.contentResolver

        // Create time stamped name and MediaStore entry.
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
            }
        }

        // Create output options object which contains file + metadata
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues)
            .build()

        // Set up image capture listener, which is triggered after photo has
        // been taken
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(mContext),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                }

                override fun
                        onImageSaved(output: ImageCapture.OutputFileResults){
                    val msg = "Photo capture succeeded: ${output.savedUri}"
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                }
            }
        )
    }*/


}