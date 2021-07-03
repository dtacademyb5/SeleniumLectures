package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SubmitMethod {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().window().maximize();



        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("soccer shoes");
        driver.findElement(By.name("btnK")).click();

    }
}
