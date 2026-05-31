package qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;
    public static FileReader fr2;

    public static Properties locator = new Properties();


    @BeforeMethod
    public void tearUp() throws IOException {
        if (driver==null){
            fr = new FileReader(System.getProperty("user.dir") + "/src/main/java/qa/configfiles/config.properties");
            fr2 = new FileReader(System.getProperty("user.dir") + "/src/main/java/qa/configfiles/locators.properties");
            //System.out.println("The path is: " + System.getProperty("user.dir"));
            //FileReader fr = new FileReader("/Users/kunduzsydykova/Documents/RCV_framework/src/main/java/qa/configfiles/config.properties");
            prop.load(fr);
            locator.load(fr2);
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("testurl"));
        }

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("Teardown");
}



}
