package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WarmUpTask {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.get("https://www.cars.com/");

        Select dropdownBoxYear = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        dropdownBoxYear.selectByVisibleText("Used cars");
        Select slt2=new Select(driver.findElement(By.id("makes")));
        slt2.selectByValue("audi");
        Select slt3=new Select(driver.findElement(By.id("models")));


        slt3.selectByVisibleText("R8");

        driver.findElement(By.xpath("//button[.='Search'][@data-linkname='search-used-make']")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().contains("Audi R8"));





    }
}
