package scripts

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class Scripts {
    fun takePicFromHuggingFace(promt:String): String {
        val options = ChromeOptions()
        options.addArguments("--start-maximized","--headless")
        val driver: WebDriver = ChromeDriver(options)
        driver.get("https://huggingface.co/spaces/AP123/SDXL-Lightning")
        val wait = WebDriverWait(driver, Duration.ofSeconds(30))

        driver.switchTo().frame(0)
        val promtWeb: WebElement =
            wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"component-5\"]/label/textarea")))
        promtWeb.sendKeys(promt)
        val buttonClick: WebElement = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"component-7\"]")))
        buttonClick.click()
        val imgWeb: WebElement =
            wait.until(visibilityOfElementLocated(By.xpath("/html/body/gradio-app/div/div/div[1]/div/div/div[4]/button/div/img")))
        driver.quit()
        return imgWeb.getAttribute("src")
    }

}