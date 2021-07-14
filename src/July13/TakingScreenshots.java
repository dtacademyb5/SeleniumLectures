package July13;

import July8.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TakingScreenshots {


    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.manage().window().maximize();


        driver.get("https://www.google.com/");


        driver.findElement(By.name("q")).sendKeys("Audi R8");

        driver.findElement(By.name("btnK")).click();

        Utilities.takeScreenshot(driver, "file1.png");





    }



}
