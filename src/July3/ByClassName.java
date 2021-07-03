package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByClassName {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nuclues\\Documents\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/"); // navigates to a URL

        driver.manage().window().fullscreen(); // maximizes the window

        driver.findElement(By.className("scroll-down-link")).click();   // className can only accept one class attribute value
        // it will not work for multiple classes


    }

}
