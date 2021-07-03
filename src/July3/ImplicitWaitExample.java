package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nuclues\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Implicit wait is set for the lifetime of Webdriver object
        // Implicit wait is applicable to all findElement()/findElements() methods

        driver.get("https://www.duotech.io/"); // navigates to a URL

        driver.manage().window().maximize();



        driver.findElement(By.xpath("//a[@href='/about-us']")).click();

        driver.findElement(By.xpath("//input[@value='Submit Messag']")).click();





    }
}
