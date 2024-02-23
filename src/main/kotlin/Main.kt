import scripts.Scripts
import utils.StringUtils

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val outputPath = "decoded_image.png"
            val promt = "кошка в шляпе"
            StringUtils().decodeBase64ToImage(StringUtils().encodeImageToBase64(Scripts().takePicFromHuggingFace(promt)), outputPath)
            println("Изображение сохранено в файл $outputPath")
        }
    }
}