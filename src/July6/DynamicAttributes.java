package July6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicAttributes {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://register.rediff.com/register/register.php?");

        String xpath = "//input[ starts-with(  @name, 'name'  ) ]" ;
        driver.findElement(By.xpath(xpath)).sendKeys("Duotech");

        // if the attribute value is entirely dynamic (there is no static part), you have to use other attributes or other location startegies
        // Or use absolute xpath if you are sure that the elements are not going to be modified
        ///html/body/center/form/div/table[2]/tbody/tr[32]/td[3]/input

        driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[32]/td[3]/input")).sendKeys("blabla");



    }
}
