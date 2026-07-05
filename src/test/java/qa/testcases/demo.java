package qa.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class demo {

    public static void main() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://tmsearch.uspto.gov/search/search-information");

        driver.findElement(By.cssSelector("#mat-select-value-0")).click();
       List<WebElement> list = driver.findElements(By.xpath("//span[@class='mdc-list-item__primary-text']"));



    }

    public void getList(String searchList){


    }

