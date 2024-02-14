package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class Scenario02Test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://www.amazon.com/gp/goldbox");


    }
    @Test
    public void test() throws InterruptedException {

        // Click on Today's Deals
        driver.findElement(By.id("dealTitle")).click();

        // Select filters
        new Select(driver.findElement(By.id("dealCategory"))).selectByVisibleText("Headphones");
        new Select(driver.findElement(By.id("dealFilterType"))).selectByVisibleText("grocery");
        new Select(driver.findElement(By.id("dealSortBy"))).selectByVisibleText("10% off or more");

        // Click on the fourth page and select an item
        driver.findElement(By.id("pagnNextString")).click();
        driver.findElement(By.cssSelector("div[data-index='0']")).click();

        // Add the item to the cart
        driver.findElement(By.id("add-to-cart-button")).click();

        // Go to the cart and check that the item is added successfully
        driver.findElement(By.id("nav-cart")).click();
        WebElement cartItem = driver.findElement(By.cssSelector("div[data-index='0'] span.a-size-medium"));
        if (cartItem.getText().contains("Today's Deals")) {
            System.out.println("Item added to the cart successfully!");
        } else {
            System.out.println("Item not found in the cart.");
        }

    }



    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
