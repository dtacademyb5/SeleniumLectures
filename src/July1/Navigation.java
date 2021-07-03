package July1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/"); // navigates to a URL

        driver.navigate().to("https://www.amazon.com/");


        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
