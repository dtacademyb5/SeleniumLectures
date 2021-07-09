package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DropdownsWithNoSelect {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get(" https://carsandbids.com/");

       //ElementNotInteractableException: element not interactable
        // The element is on the HTML code, but might be off the focus,/invisible, it might be covered/shadowed by the other element

        driver.findElement(By.xpath("//span[.='Transmission']")).click();
        driver.findElement(By.xpath("//button[.='Manual']")).click();

    }
}
