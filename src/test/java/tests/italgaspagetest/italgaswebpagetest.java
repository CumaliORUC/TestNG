package tests.italgaspagetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class italgaswebpagetest {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown() {
       // driver.close();
    }
    @Test

    public void test01() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement search= driver.findElement(By.name("q"));   // Go to Google page

        search.sendKeys("italgas"+ Keys.ENTER);   //Search Italgas

        driver.findElement(By.xpath("//cite[@role='text']")).click();  // click to italgas.com

        driver.findElement(By.partialLinkText("English")).click();  // Select English

        driver.findElement(By.xpath("(//a[@class='CybotCookiebotDialogBodyButton'])[3]")).click();  //Accept necessary cookies only

        Thread.sleep(10000);

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//span[@id='itg_header_tab_span_21230'] ")).click();  //About us

}
}