package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AutoSuggestiveDynamicDropdowns {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--enable-strict-powerful-feature-restrictions");

        WebDriver driver = new ChromeDriver(options);




        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();



        driver.get(" https://www.spirit.com/");





        driver.findElement(By.id("flight-OriginStationCode")).click();

        Thread.sleep(2000);

//        driver.findElement(By.xpath("(//button[contains( text(), 'BWI')])[2]")).click();

        driver.findElement(By.id("flight-DestinationStationCode")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//button[contains( text(), 'PUJ')])[2]")).click();







    }
}
