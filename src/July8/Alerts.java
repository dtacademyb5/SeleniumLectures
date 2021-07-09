package July8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alerts {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        //When a JS Alert is not handled, irt will result in UnhandledAlertException: unexpected alert open: {Alert text : I am a JS Alert}

        Alert alert = driver.switchTo().alert();
        //Switches to the currently active modal dialog for this particular driver instance.

        alert.accept();

      //  driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'examples')]")).getText());

         Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'examples')]")).getText());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'examples')]")).getText());


    }
}
