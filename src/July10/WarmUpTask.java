package July10;

import July8.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarmUpTask {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.bloomberg.com/markets/stocks");

        driver.manage().deleteAllCookies();



        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-view-uid='1|0_3_3']//tr[@class='data-table-headers']//th"));
        List<String> expectedHeaders = Arrays.asList("NAME" , "VALUE", 	"NET CHANGE", "% CHANGE", 	"1 MONTH", 	"1 YEAR", 	"TIME (EDT)");
        List<String> actualHeaders = Utilities.getElementsText(elements);

        Assert.assertEquals(actualHeaders, expectedHeaders);

        // 3. Verify the first column of the Americas Table:
        List<WebElement> verifyFirstCol = driver.findElements(By.xpath("//div[@data-view-uid='1|0_3_3']//th[@class='data-table-row-cell']//div[@data-type='full']"));
//

        List<String> expectedCol = Arrays.asList( "DOW JONES INDUS. AVG" ,  "S&P 500 INDEX" ,  "NASDAQ COMPOSITE" ,  "NYSE COMPOSITE INDEX" ,  "S&P/TSX COMPOSITE INDEX" );

        List<String> actualCol = Utilities.getElementsText(verifyFirstCol);

        Assert.assertEquals(actualCol, expectedCol);







    }


    @Test
    public void bloombergTAbleVerification(){

    }

}
