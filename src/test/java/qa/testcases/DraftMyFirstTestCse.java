package qa.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

import static qa.base.BaseTest.driver;

public class DraftMyFirstTestCse {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //base
        WebDriver driver = new ChromeDriver();   //base
        driver.manage().window().maximize();     //base
        driver.navigate().to("https://www.zoho.com/");   //property file
        driver.findElement(By.linkText("Sign In")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login_id']")));

        Actions actions = new Actions(driver);
        actions.sendKeys(el, "kunduz.it92@gmail.com").build().perform();
        driver.findElement(By.id("nextbtn")).click();


        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        actions.sendKeys(pass, "Kunduz26$").build().perform();
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
        Thread.sleep(5000);

         String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Zoho Home");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close();

    }
}
