package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class Scenario02Test {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.navigate().to("\"https://www.amazon.eg\"");

    }
    @Test
    public void test()
    {
        driver.findElement(By.className("nav-a")).click();
        driver.findElement(By.className("CheckboxFilter-module__gridFilterCheckbox_9gZBKxneWNZMc30ac9ue7 Checkbox-module__checkBoxOutline_281PiTekJcpF_Pm5QDexLv")).click();
        driver.findElement(By.className("CheckboxFilter-module__gridFilterCheckbox_9gZBKxneWNZMc30ac9ue7 Checkbox-module__checkBoxOutline_281PiTekJcpF_Pm5QDexLv")).click();
        driver.findElement(By.className("BadgeAutomatedLabel-module__badgeAutomatedLabel_2Teem9LTaUlj6gBh5R45wd")).click();
    }


    @AfterMethod
    public void quetdriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
