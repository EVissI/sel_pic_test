import kotlinx.coroutines.runBlocking
import openai.request.OpenAIRequests
import scripts.Scripts
import utils.StringUtils

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val outputPath = "decoded_image.png"
            val prompt = "cat in hat on moon"
            val openAIRequests = OpenAIRequests()
            runBlocking {
                val updatedPrompt = openAIRequests.generatePrompt(prompt)
                StringUtils().decodeBase64ToImage(StringUtils().encodeImageToBase64(Scripts().takePicFromHuggingFace(updatedPrompt)), outputPath)
                println("Изображение сохранено в файл $outputPath")
            }

        }
    }
}