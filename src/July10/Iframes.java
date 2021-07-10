package July10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Iframes {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/iframe");


        driver.switchTo().frame("mce_0_ifr"); // switches the context to the iframe

        System.out.println(driver.findElement(By.xpath("//p")).getText());

        driver.switchTo().defaultContent();
        //Selects either the first frame on the page, or the main document when a page contains iframes.

        driver.switchTo().parentFrame();
        //Change focus to the parent context. If the current context is the top level browsing context, the context remains unchanged.

        driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();



    }
}
