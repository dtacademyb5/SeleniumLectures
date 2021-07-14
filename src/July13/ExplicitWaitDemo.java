package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitDemo {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait  = new WebDriverWait(driver, 10);

        WebElement helloWorldText = driver.findElement(By.xpath("//h4[.='Hello World!']"));

        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

//      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));

        System.out.println(helloWorldText.getText());

        // Explicit wait applies to a specific element only
        // Default polling interval is 500 milliseconds
    }
        }
