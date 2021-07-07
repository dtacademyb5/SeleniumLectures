package July6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CSSSelctor {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.duotech.io/");

//        String cssPath = "#Services > div.section-header-wrapper > h2";

        driver.findElement(By.cssSelector("html body div"));

//        driver.findElement(By.cssSelector("#Services > div.section-header-wrapper > h2"));

        System.out.println(driver.findElement(By.cssSelector("p.paragraph-big")).getText());
      //  p.paragraph-big  ->  p element with a class paragraph-big

        System.out.println(driver.findElement(By.cssSelector(".paragraph-big")).getText());
        // first element with a class paragraph-big

        driver.findElement(By.cssSelector("div.contact-window.popup-window"));
        //div.contact-window.popup-window -> div with classes contact-window and popup-window

        driver.findElement(By.cssSelector("input#name-2")).sendKeys("Hola");
//        input#name-2 -> input element with an id name-2

        driver.findElement(By.cssSelector("#name-2"));

        driver.findElement(By.cssSelector("div[data-w-id='92c1b980-fe6d-eb89-3ea1-81623181a21b']"));
        //  div[data-w-id='92c1b980-fe6d-eb89-3ea1-81623181a21b']  -> a div element with data-w-id attribute with value '92c1b980-fe6d-eb89-3ea1-81623181a21b'

        // using multiple attributes
      //  div[data-w-id='92c1b980-fe6d-eb89-3ea1-81623181a21b'][class='service-simple w-clearfix']


    }
}
