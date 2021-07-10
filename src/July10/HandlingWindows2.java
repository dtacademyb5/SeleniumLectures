package July10;

import July8.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingWindows2 {
   static WebDriver driver;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.toyota.com/");

        //Using window titles to switch to a window


        driver.findElement(By.xpath("//a[@href='https://privacy.toyota.com/']")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("Toyota - Lexus Privacy Hub")){
                break;
            }
        }

        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@href='https://www.toyota.com/support/california-privacy']")).sendKeys(Keys.LEFT_SHIFT , Keys.ENTER);

        Utilities.switchToWindow("Support", driver);

        System.out.println(driver.getTitle());


        //Switch back to first window

        Utilities.switchToWindow("New Cars, Trucks, SUVs & Hybrids | Toyota Official Site", driver);

        System.out.println(driver.getTitle());





    }


    public static void switchToWindow(String title){

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(title)){
                break;
            }
        }
    }
}
