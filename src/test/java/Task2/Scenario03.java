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
        //set implicit wait--only written one time
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
        driver.findElement(By.id("journeyDate")).clear();
        driver.findElement(By.id("journeyDate")).sendKeys("2023-03-26");

        // Click "Search for bus"
        driver.findElement(By.id("searchBtn")).click();

        // Select a seat
        driver.findElement(By.xpath("//table[@class='table table-striped seat-avail-table']/tbody/tr[1]/td[3]")).click();

        // Choose the boarding point and dropping point
        new Select(driver.findElement(By.id("srcTpId"))).selectByVisibleText("MARIYANNAPALYA");
        new Select(driver.findElement(By.id("destTpId"))).selectByVisibleText("MAJESTIC");

        // Fill the "Customer" and "Passenger" details
        driver.findElement(By.id("custName")).sendKeys("John Doe");
        driver.findElement(By.id("mobileNo")).sendKeys("6789125987");
        driver.findElement(By.id("email")).sendKeys("john.doe@example.com");

        // Fill the passenger details
        driver.findElement(By.id("paxCorrespondenceName")).sendKeys("Jane Doe");
        driver.findElement(By.id("paxMobileNo")).sendKeys("6789125987");
        driver.findElement(By.id("paxEmail")).sendKeys("jane.doe@example.com");

        // Click on "make payment"
        driver.findElement(By.id("bookBtn")).click();



    }

    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}