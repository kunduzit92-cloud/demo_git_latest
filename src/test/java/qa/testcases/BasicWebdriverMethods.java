package qa.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import qa.base.BaseTest;

public class BasicWebdriverMethods {

    static void main() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("Amazon", url);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }






}
