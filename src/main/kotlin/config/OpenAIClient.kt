package config

import com.aallam.openai.api.http.Timeout
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import java.io.FileInputStream
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.*
import kotlin.time.Duration.Companion.seconds

class OpenAIClient {
    private val config: OpenAIConfig

    init {
        val properties = Properties()
        val configFile = FileInputStream("config.properties")
        properties.load(configFile)

        val host = properties.getProperty("proxy.host")
        val port = properties.getProperty("proxy.port").toInt()

        val proxyServer = Proxy(
            Proxy.Type.HTTP,
            InetSocketAddress(host,port)
        )
        val apiKey = properties.getProperty("openai.api.key")
        config = OpenAIConfig(
            token = apiKey,
            timeout = Timeout(socket = 60.seconds),
            httpClientConfig =  {
                engine {
                    proxy = proxyServer
                }
            }
        )

    }

    private val client = OpenAI(config)

    fun getClient(): OpenAI {
        return client
    }

}