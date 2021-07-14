package July13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSExecutorDemo {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().window().maximize();


        driver.get("https://www.amazon.com/");


        JavascriptExecutor js = (JavascriptExecutor) driver; // cast driver to JSExecutor

        js.executeScript("document.getElementById('twotabsearchtextbox').value='Audi Q8';");


        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Go']")));


        js.executeScript("alert('Testing amazon page. This is a JS Alert');");


        driver.switchTo().alert().dismiss();

        js.executeScript("history.go(0)");  //refresh

        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,-1000)");


//        driver.findElement(By.xpath("//a[.='Prime Membership']")).click();

        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[.='Prime Membership']")));
//



    }
}
