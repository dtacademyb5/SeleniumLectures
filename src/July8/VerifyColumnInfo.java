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

public class VerifyColumnInfo {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.xpath("//a[.='View all products']")).click();


        List<String> expected = Arrays.asList( "MyMoney", 	"FamilyAlbum",	"ScreenSaver");

        List<WebElement> firstColumn = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));

        List<String> actual = Utilities.getElementsText(firstColumn);

        Assert.assertEquals(actual, expected);


        System.out.println(getColumnInfo(2));

        System.out.println(getColumnInfo(3));

    }


    public static List<String> getColumnInfo(int columnNo){

        List<WebElement> column = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td["+columnNo+"]"));

        List<String> strings = Utilities.getElementsText(column);

        return strings;
    }
}
