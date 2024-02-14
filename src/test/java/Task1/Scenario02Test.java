package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Scenario02Test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://www.amazon.eg/-/en/deals?ref_=nav_cs_gb");


    }
    @Test
    public void test() throws InterruptedException {


        // Select filters
        List<WebElement> amazon = driver.findElements(By.cssSelector("ul[class=\"a-nostyle\"]"));
        System.out.println(amazon.size());
        List<WebElement> amazon2 = amazon.get(2).findElements(By.cssSelector("li"));
        System.out.println(amazon2.size());
        amazon2.get(8).click();
        amazon2.get(12).click();


       // from the discount part choose "10% off or more"
        List<WebElement> amazon3 = amazon.get(5).findElements(By.cssSelector("li"));
        amazon3.get(1).click();



        // Add the item to the cart
        driver.findElement(By.cssSelector("img[alt=\"Save on Mobiles Chargers & Accessories\"]")).click();

        // Go to the cart and check that the item is added successfully


    }



    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
