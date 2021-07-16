package July15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckingElementsState {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();



        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        while(!element.isEnabled()){

        }

        element.sendKeys("Whatever");

//        while(!element.isDisplayed()){
//
//        }


    }
}
