package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GetAttributeMethod {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement usernameInputBox = driver.findElement(By.name("ctl00$MainContent$username"));

        System.out.println( usernameInputBox.getAttribute("type"));
        System.out.println( usernameInputBox.getAttribute("class"));
        System.out.println( usernameInputBox.getAttribute("style"));

        String wrongAtt = usernameInputBox.getAttribute("lang");  //wrong attribute returns empty string

        System.out.println(wrongAtt);


        driver.get("https://www.dice.com/");

        String expectedPlaceholder = "Job title, skills or company";

       String actualPlaceholder =  driver.findElement(By.id("typeaheadInput")).getAttribute("placeholder");

        assertEquals(actualPlaceholder, expectedPlaceholder);

        driver.findElement(By.id("typeaheadInput")).sendKeys("QA Engineer" + Keys.ENTER);

        //To retrieve an input box's text we need to use getAttribute("value");
        System.out.println(driver.findElement(By.id("typeaheadInput")).getAttribute("value"));
    }
}
