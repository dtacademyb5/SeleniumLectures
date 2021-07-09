package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicWebTableActions {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.xpath("//a[.='View all products']")).click();

        // Get the no of rows

        int rowNum = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr")).size();

        int colNum = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[1]//th")).size();

        // first row, first col element
//        System.out.println(driver.findElement(By.xpath("//table[@class='ProductsTable']//tr[1]//th[1]")).getText());


        for (int i = 2; i <= rowNum; i++) {

            for (int j = 1; j <= colNum; j++) {

                String xpath = "//table[@class='ProductsTable']//tr["+i+"]//td["+j+"]";
//                System.out.print(xpath + "                   ");

                System.out.print(driver.findElement(By.xpath(xpath)).getText() + "\t");

            }

            System.out.println();

        }


    }
}
