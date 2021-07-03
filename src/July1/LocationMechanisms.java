package July1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocationMechanisms {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.get("https://www.duotech.io/"); // navigates to a URL

        WebElement h2 = driver.findElement(By.className("section-header"));

        System.out.println(h2.getText());

        List<WebElement> elements = driver.findElements(By.className("section-header"));

        System.out.println(elements.size());

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }




    }
}
