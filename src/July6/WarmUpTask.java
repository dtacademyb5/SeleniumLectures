package July6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarmUpTask {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        WebDriver wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wd.get("https://www.dice.com/");

        wd.findElement(By.id("typeaheadInput")).sendKeys("SDET");

        wd.findElement(By.id("google-location-search")).sendKeys("Virginia", Keys.ENTER);


//        List<WebElement> elements = wd.findElements(By.className("card-title-link"));
//        List<WebElement> elements = wd.findElements(By.xpath("//a[@class='card-title-link bold']"));
        List<WebElement> elements = wd.findElements(By.xpath(" //div[@id='searchDisplay-div']//a[@class='card-title-link bold']"));
        //div[@id='searchDisplay-div']//a[@class='card-title-link bold']


        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().contains("SDET"));
        }
        System.out.println("Count of SDET links are: " + elements.size());
        wd.close();




    }
}
