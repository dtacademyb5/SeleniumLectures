package July10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Iframes2 {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.duotech.io/enroll-sqae2");
//        driver.switchTo().frame("1625931792748_448915483028023"); // switches the context to the iframe

        WebElement iframe = driver.findElement(By.xpath("//iframe[ starts-with( @id, '1625')]"));

//        driver.switchTo().frame(iframe); // switch to a frame by passing iframe Webelement as an argument

        driver.switchTo().frame(0); // Select a frame by its (zero-based) index.

        driver.findElement(By.xpath("//input[@placeholder='First']")).sendKeys("Duotech");

        // When a frame is nested within another frame, we must switch to the first frame and from there switch to the inner frame
        // When a page has 2 independent iframes, and if the script requires us to do an action on both frames:
           // Flow: Switch to frame 1, switch back to main window (defaultContent()), switch to frame 2




//





    }
}
