package Task2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario03 {
    WebDriver driver;

    @BeforeMethod

    public void openBrowser() {

        driver = new ChromeDriver();
        //set implicit wait--only written one time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");

    }

    @Test
    //testbookbusticket
    public void test() throws InterruptedException {


        // Choose "Chikkamagaluru" to "Bengaluru" from the popular routes
        driver.findElement(By.name("fromPlaceName")).click();
        driver.findElement(By.id("fromPlaceName")).sendKeys("CHIKKAMAGALURU");
        Thread.sleep(2000);

         driver.findElement(By.name("toPlaceName")).click();
         driver.findElement(By.id("toPlaceName")).sendKeys("BENGALURU");

        // Choose the arrival date
        //driver.findElement(By.name("txtReturnJourneyDate")).sendKeys("02/13/2024");
        String arrivalDate = "02/13/2024";
        driver.findElement(By.name("txtReturnJourneyDate")).sendKeys(arrivalDate);

        // Click "Search for bus"
        driver.findElement(By.className("btn btn-primary btn-lg btn-block btn-booking")).click();

        // Select a seat
        driver.findElement(By.name("SrvcSelectBtnForward")).click();











    }

    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}