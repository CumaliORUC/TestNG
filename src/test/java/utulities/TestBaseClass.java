package utulities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public abstract class TestBaseClass {

   protected WebDriver driver;
        @BeforeClass
            public void setup() {
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @AfterClass
            public void teardown() {
                driver.close();
        }
}
