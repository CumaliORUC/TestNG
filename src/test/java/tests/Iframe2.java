package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
/*
    Go to https://html.com/tags/Iframe/ adress
    And play the video
 */

public class Iframe2 {


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
           // driver.close();
    }
    @Test
        public void Iframe01() throws InterruptedException {
            driver.get("https://html.com/tags/Iframe/");
            Actions a = new Actions(driver); //scroll down a page
                a.sendKeys(Keys.PAGE_DOWN).build().perform();
            WebElement Iframelocation= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
            driver.switchTo().frame(Iframelocation); //Enter to Iframe
                driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();  // Click to play
            driver.switchTo().defaultContent(); //exit from frame
    }
}

