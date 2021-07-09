package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyRowInfo2 {

   static WebDriver driver;


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

       driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


       List<String> expected = Arrays.asList("Paul Brown",	"ScreenSaver",	"2",	"03/12/2010",	"5, Ringer Street",	"Las Vegas, NV",    "US",	"748",	"MasterCard",	"123456789012", 	"02/07");

        List<WebElement> firstRow = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td"));

        List<String> actual = Utilities.getElementsText(firstRow);

        Assert.assertEquals(actual, expected);


        // Retrieve the info from the 6th row

        System.out.println(getRowInfo(5));

        System.out.println(getRowInfo(8));

    }


    public static List<String> getRowInfo(int rowNo){

        List<WebElement> firstRow = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[" + rowNo+ "]//td"));

        List<String> actual = Utilities.getElementsText(firstRow);

        return actual;
    }

}
