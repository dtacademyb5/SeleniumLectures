package July8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicTableHAndling {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        WebDriver driver= new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        String expectedTerm = "Quess Corp";

        // Find the location of this text within this dynamic table

        int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
        int cols = driver.findElements(By.xpath("//table//thead//th")).size();

 boolean notFound  =  true;
    outer:    for (int i = 1; i <=rows ; i++) {

            for (int j = 1; j <= cols; j++) {

                String xpathDynamic = "//table//tbody//tr["  + i +  "]//td[" + j + "]" ;
                String eachCellText = driver.findElement(By.xpath(xpathDynamic)).getText().trim();

                if(eachCellText.equals(expectedTerm)){
                    System.out.println("The expected term " + expectedTerm + " is located at row " + i + " and at column " + j) ;
                    notFound = false;
                     break outer;

                }

            }

        }

        if(notFound){
            System.out.println("The expected term not found");
        }

    }
}
