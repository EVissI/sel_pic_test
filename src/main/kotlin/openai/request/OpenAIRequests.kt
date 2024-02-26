package openai.request

import com.aallam.openai.api.edits.EditsRequest
import com.aallam.openai.api.model.ModelId
import config.OpenAIClient


class OpenAIRequests {
    suspend fun generatePrompt(prompt:String) : String{
        val openAIClient = OpenAIClient().getClient()

        val edit =  openAIClient.edit(
            request = EditsRequest(
                model = ModelId("text-davinci-edit-001"),
                input = prompt,
                instruction = "Fix the spelling mistakes"
            )
        )
        return edit.choices[0].text
    }

}