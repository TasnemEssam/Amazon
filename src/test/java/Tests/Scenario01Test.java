package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Scenario01Test {

    WebDriver driver;

    //login to amazon page

    @BeforeMethod
    public void OpenBrowser() {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.navigate().to("https://www.amazon.eg");

    }
    @Test
    public void test() throws InterruptedException {
       // driver.findElement(By.name("site-search")).click();
        //driver.findElement(By.name("site-search")).sendKeys("car accessories");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car accessories", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[class=\"s-image\"]")).click();
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("nav-cart")).click();
        assert driver.findElement(By.cssSelector(".sc-product-title")).getText().contains("car accessories");


    }


    @AfterMethod

    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}