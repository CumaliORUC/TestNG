package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class DepensOnTrendyol

{
/*
    Bir class oluşturun: DependsOnTest
   ● https://www.walmart.com/ adresine gidin.
            1. Test : Trendyol ana sayfaya gittiginizi test edin
            2. Test : 1.Test basarili ise search Box’i kullanarak “Iphone” icin arama yapin ve aramanizin gerceklestigini Test edin
            3.Test : “Iphone” icin arama yapildiysa ilk urunu tiklayin ve "Apple"oldugunu test edin

 */
    WebDriver driver;
    @BeforeClass
        public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

     @AfterClass
        public void teardown() {
        // driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.trendyol.com/");

        driver.findElement(By.xpath("(//div[@class='homepage-popup-content'])[2]")).click();

        String actualtitle=driver.getTitle();
        String expectedtitle="Trendyol";

        System.out.println(actualtitle);

        Assert.assertTrue(actualtitle.contains(expectedtitle));
    }

    @Test  (dependsOnMethods = "test01")
    public void test02() {

        WebElement searchbox=driver.findElement(By.cssSelector(".search-box"));
        searchbox.sendKeys("Iphone"+ Keys.ENTER);
        WebElement results=driver.findElement(By.cssSelector("div.dscrptn"));
        String actualresult=results.getText();
        String expectedresult="Iphone";
        Assert.assertTrue(actualresult.contains(expectedresult));
    }

    @Test (dependsOnMethods = "test02")
    public void test03() throws InterruptedException {

        Thread.sleep(4000);

        Thread.sleep(3000);
        WebElement firstIphone= driver.findElement(By.xpath("(//span[@title='Apple'])[1]"));
        String actualtitle= firstIphone.getText();
        System.out.println(actualtitle);

        String expectedtitle="Apple";

        Assert.assertEquals(actualtitle,expectedtitle,"Maalesef aynı değil");

    }
}