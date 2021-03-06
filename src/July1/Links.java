package July1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Links {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("os.name").contains("Windows") ? "drivers/chromedriver.exe" : "drivers/chromedriver");

        WebDriver driver = new ChromeDriver(); // launches a new browser session

//        driver.get("https://www.duotech.io/"); // navigates to a URL
//
//        driver.findElement(By.linkText("About")).click();
//
//        driver.findElement(By.partialLinkText("Con")).click();


        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"); //step 1

        String currentTitleName= driver.getTitle();

        String expectedTitleName="Welcome to Duotify!"; //  step 2

        if(currentTitleName.equals(expectedTitleName)){
            System.out.println("Title name matches!");
        }else{
            System.err.println("Title name does not match!");
        }

        String s = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPGTSTIVWXYZ";
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += s.charAt((int) (Math.random() * s.length()));
        }

        driver.findElement(By.id("hideLogin")).click(); //step 3

        driver.findElement(By.id("username")).sendKeys(password);

        driver.findElement(By.id("firstName")).sendKeys("Oyatullo");

        driver.findElement(By.id("lastName")).sendKeys("Sirojev");

        driver.findElement(By.id("email")).sendKeys(password+"@gmail.com");

        driver.findElement(By.id("email2")).sendKeys(password+"@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Ago060707");

        driver.findElement(By.id("password2")).sendKeys("Ago060707"+ Keys.ENTER);

        // driver.findElement(By.xpath("//*[@id='registerForm']")).submit();






        // driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).submit();

        String URL = driver.getCurrentUrl();
        assertTrue(URL.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));


        driver.findElement(By.id("nameFirstAndLast")).click();

        assertTrue(driver.getPageSource().contains("Oyatullo Sirojev"));

        Thread.sleep(2000);

        driver.findElement(By.id("rafael")).click();

        String URL2 = driver.getCurrentUrl();
        assertTrue(URL2.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Thread.sleep(2000);



        driver.findElement(By.id("loginUsername")).sendKeys(password);

        driver.findElement(By.id("loginPassword")).sendKeys("Ago060707"+Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.id("nameFirstAndLast")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("rafael")).click();

        driver.quit();

    }
}
