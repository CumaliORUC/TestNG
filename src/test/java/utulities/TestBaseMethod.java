package utulities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public abstract class TestBaseMethod {

   protected WebDriver driver;
        @BeforeMethod
            public void setup() {
                 WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @AfterMethod
            public void teardown() {
                driver.close();
    }
}
