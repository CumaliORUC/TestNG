package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.security.KeyFactorySpi;
import java.util.concurrent.TimeUnit;

    /*
    ● https://the-internet.herokuapp.com/javascript_alerts .
    ●  AcceptAlert
    ○ 1. Click to first Opiton and click OK then test the
         “You successfully clicked an alert” text isDisplayed
    ●  DismisAlert
    ○ Click to Second Opiton and click Cancel then test the
    “successfuly” is not display
    ●  sendKeysAlert
    ○ Click to Third Opiton, Text your name in the textbox, Click to OK then
       test your name is Display at result mesagge.
     */

public class Alerts {

    WebDriver driver;
    @BeforeClass
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
    }
    @AfterClass
        public void  teardown() {
            driver.close();

    }
        /*
        AcceptAlert
         ** Click to first Opiton and click OK then test the
         “You successfully clicked an alert” text isDisplayed
         */
    @Test
        public void acceptAlert () {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
            driver.switchTo().alert().accept();
            WebElement resulttext= driver.findElement(By.cssSelector("p#result"));
                Assert.assertTrue(resulttext.isDisplayed());
    }
        /*
        DismisAlert
            Click to Second Opiton and click Cancel then test the
            “successfuly” is not display
         */
    @Test
        public void dismisAlert () {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
            driver.switchTo().alert().dismiss();
            WebElement resulttext= driver.findElement(By.cssSelector("p#result"));
                Assert.assertFalse(resulttext.getText().equals("succesfuly"));
    }

    /*
        sendKeysAlert
    ○ Click to Third Opiton, Text your name in the textbox, Click to OK then
       test your name is Display at result mesagge.
     */
    @Test
        public void SendKeys () {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
            driver.switchTo().alert().sendKeys("Ali is qualified person");
            driver.switchTo().alert().accept();
                String actualresult=driver.findElement(By.cssSelector("p#result")).getText();
                String expectedresult="Ali is qualified person";
                Assert.assertTrue(actualresult.contains(expectedresult));

    }
}
