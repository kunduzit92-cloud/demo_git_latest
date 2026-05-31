package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.base.BaseTest;

import java.time.Duration;

public class MyFirstTest extends BaseTest {

    @Test(dataProvider = "testdata")
    public static void loginTest(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText(locator.getProperty("signin_link"))).click();
        Thread.sleep(5000);
        WebElement userField = driver.findElement(By.xpath(locator.getProperty("user_field")));
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.sendKeys(username).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(locator.getProperty("password_field")));
        actions.sendKeys(password).build().perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath(locator.getProperty("login_button"))).click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Zoho Home");


    }

    @DataProvider(name="testdata")
    public Object[][] tdata() {
        return new Object[][]
                {
                        {"invalid user", "invalid pass"},
                        {"inv123", "123invalidpass"},
                        {"kunduz.it92@gmail.com", "Kunduz26$"}

                };
    }

    }




