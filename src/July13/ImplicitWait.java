package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        System.out.println(driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());

        // implicit wait is set for all element location actions (findElement(), findElements())
        // it is active for the lifetime of the driver object
        // when it is set for a given amount of time, the impliocit timeout will keep looking for the element every 0.5 seconds
        // default polling frequency  - 500 ms (0.5 s)
        // As soon as an element is found the wait will be over, and the rest of the script will continue


        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  // we can reset the implicit wait at any time during our script

        driver.navigate().refresh();

        driver.findElement(By.xpath("//button[.='Start']")).click();

        System.out.println(driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());


    }
}
