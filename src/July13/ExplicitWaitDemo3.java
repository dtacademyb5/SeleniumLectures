package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitDemo3 {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.carfax.com/");
//       Code to simulate a random alert popping up within 5-20 seconds
//        JavascriptExecutor js  = (JavascriptExecutor) driver;
//        int randomSec = 5000+ (int)(Math.random()*15000);
//        Thread.sleep(randomSec);
//        js.executeScript("alert('Hello this is a random alert!');");
////
        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("(//a[@href='/cars-for-sale'])[2]")).click();


        // If an explicit wait condition is not met, TimeOutException is thrown
        // Example: TimeoutException: Expected condition failed: waiting for alert to be present (tried for 5 second(s) with 500 milliseconds interval)

    }
        }
