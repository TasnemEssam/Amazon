package Task2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Scenario03 {
    WebDriver driver;

    @BeforeMethod

    public void openBrowser() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");

    }

    @Test
    //testbookbusticket
    public void test() throws InterruptedException {

        // Choose the source and destination
        driver.findElement(By.id("fromPlaceName")).sendKeys("CHIKKAMAGALURU");
        driver.findElement(By.id("toPlaceName")).sendKeys("BENGALURU");

        // Choose the arrival date
        driver.findElement(By.id("txtReturnJourneyDate")).sendKeys("2024-05-26");
        driver.findElement(By.id("txtJourneyDate")).sendKeys("2024-03-6");


        // Click "Search for bus"
        driver.findElement(By.className("btn btn-primary btn-lg btn-block btn-booking")).click();

        // Select a seat
        driver.findElement(By.xpath("//table[@class='table table-striped seat-avail-table']/tbody/tr[1]/td[3]")).click();

        // Choose the boarding point and dropping point
        new Select(driver.findElement(By.id("Forwardboarding-tab"))).selectByVisibleText("MARIYANNAPALYA");
        new Select(driver.findElement(By.id("Forwarddroping-tab"))).selectByVisibleText("MAJESTIC");

        // Fill the "Customer" and "Passenger" details





    }

    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}