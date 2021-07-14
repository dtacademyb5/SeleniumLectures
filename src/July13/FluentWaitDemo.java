package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitDemo {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.xpath("//button[.='Remove']")).click();

       Wait<WebDriver> fluentWait = new FluentWait<>(driver).
               withTimeout(Duration.ofSeconds(10)).
               pollingEvery(Duration.ofSeconds(1)).
               ignoring(NoSuchElementException.class);



        By foo = fluentWait.until(new Function<WebDriver, By>() {
            public By apply(WebDriver driver) {
                return By.id("message");
            }
        });

        System.out.println(driver.findElement(foo).getText());


        // Fluent wait is a type of Explicit wait with which you can control the polling interval, and ignore specific exceptions
    }


}
