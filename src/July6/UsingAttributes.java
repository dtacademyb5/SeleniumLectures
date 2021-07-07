package July6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsingAttributes {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.duotech.io/");

        List<WebElement> elements = driver.findElements(By.xpath("//input[@id]"));// return all input elements that have an id attribute


        List<WebElement> elements1 = 
                driver.findElements(By.xpath("//input[not( @id )]"));// return all input elements that do not have an id attribute

        List<WebElement> elements2 = driver.findElements(By.xpath("//*[@*='email']"));// return all elements with the attribute value "email" 


    }
}
