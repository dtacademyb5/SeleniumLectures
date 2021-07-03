package July1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.*;


public class BasicMethods {


    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/"); // navigates to a URL

        String currentUrl = driver.getCurrentUrl(); // retrieves the current URL

        String expectedUrl = "https://www.duotech.io/";

   //     Assert.assertEquals(currentUrl, expectedUrl);
     //   Assert.assertTrue(true);
        assertEquals(currentUrl, expectedUrl);

        String expectedTitle = "Duotech Academy";
        String actualTitle = driver.getTitle();

        assertTrue(actualTitle.contains(expectedTitle));


        String HTMLCode = driver.getPageSource();

        assertTrue(HTMLCode.contains("Start New IT&nbsp;Career"));




        driver.get("https://www.toyota.com/");
        driver.findElement(By.xpath("//a[@href='https://privacy.toyota.com/']")).click();
        Thread.sleep(2000);
//
//        driver.quit(); //Quits this driver, closing every associated window.
        driver.close(); //Closes the current active window, quitting the browser if it's the last window currently open.






    }
}
