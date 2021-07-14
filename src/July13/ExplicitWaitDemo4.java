package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo4 {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        // Explicit wait for an element to be clickable (to be enabled)
        new WebDriverWait(driver, 8).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");

//



    }
        }
