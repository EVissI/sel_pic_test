package utils

import java.io.File
import java.net.URL
import java.util.Base64

class StringUtils {
    fun encodeImageToBase64(imageUrl: String): String {
        val imageData = URL(imageUrl).readBytes()
        return Base64.getEncoder().encodeToString(imageData)
    }

    fun decodeBase64ToImage(base64Image: String, outputPath: String) {
        val imageBytes = Base64.getDecoder().decode(base64Image)
        val outputFile = File(outputPath)
        outputFile.writeBytes(imageBytes)
    }
}