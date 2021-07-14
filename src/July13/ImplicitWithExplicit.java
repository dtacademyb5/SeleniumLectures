package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ImplicitWithExplicit {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        driver.findElement(By.xpath("//button[.='Start']")).click();

        // Don't mix explicit with implicit wait


        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // set it to zero first

        WebDriverWait wait  = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));  // apply the explicit wait

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // once the explicit wait is done, set it back to previous value





    }
}
