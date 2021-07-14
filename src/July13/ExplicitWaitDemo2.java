package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo2 {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait  = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        // most methods of ExpectedConditions class have 2 overloaded versions, one that accepts WebElement and one that accepts By Object
        // If the element that you are applying the explicit wait is not on the html code yet, you need to use the version that accepts By object
        // In the second case, the driver will poll the page without calling the findElement method


        System.out.println(driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());

        // Explicit wait applies to a specific element only
    }
        }
