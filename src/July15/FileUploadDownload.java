package July15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FileUploadDownload {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://70.32.24.165");

        driver.findElement(By.xpath("//h4[.='Remote Notarization']")).click();

        driver.findElement(By.xpath("//div[.='Schedule']")).click();

        driver.findElement(By.xpath("//input[@id='documentOnline']")).sendKeys("C:\\Users\\Nuclues\\Downloads\\Automation Project Description.pdf");



        driver.get("https://unsplash.com/s/photos/free");

        new Actions(driver).moveToElement( driver.findElement(By.xpath("//a[@href='https://unsplash.com/photos/odxB5oIG_iA/download?force=true']"))).build().perform();

        driver.findElement(By.xpath("//a[@href='https://unsplash.com/photos/odxB5oIG_iA/download?force=true']")).click();




    }
}
