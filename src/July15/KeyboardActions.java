package July15;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class KeyboardActions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();



        driver.get("https://www.google.com/");


        WebElement inputBox = driver.findElement(By.name("q"));
        // Select select  = new Select(WebElement element)
//        Alert, JavascriptExecutor, TakingScreenshots -> interfaces

        Actions actions  = new Actions(driver);

        actions.keyDown(Keys.LEFT_SHIFT).sendKeys(inputBox, "hello").sendKeys(inputBox, Keys.ENTER).keyUp(Keys.LEFT_SHIFT).build().perform();

        driver.navigate().back();

        inputBox = driver.findElement(By.name("q"));

        actions.sendKeys(inputBox, "save your tears", Keys.ENTER).build().perform();



//
    }
}
