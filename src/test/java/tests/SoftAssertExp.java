package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftAssertExp {
    /*
    SoftAssertTest
    1.  Go to “http://zero.webappsecurity.com/”
    2. Click Sign in button
    3. Login username box text “username”
    4. Password box “password”
    5. Click Sign in button
    6. Click to "Pay Bills"
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select  One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)
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
        public  void teardown() {
            driver.close();
    }

    @Test
        public void softAssert01() {
            driver.get("http://zero.webappsecurity.com/");

        //2. Click Sign in button
            driver.findElement(By.id("signin_button")).click();

        //3. Login username box text “username”
            driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password box “password”
            driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");

        //5. Click Sign in button
            driver.findElement(By.name("submit")).click();

        //for security page
            driver.findElement(By.xpath("//button[@id='details-button']")).click();
            driver.findElement(By.cssSelector("#proceed-link")).click();

        // 6. Click to "Pay Bills"
            driver.findElement(By.partialLinkText("Pay")).click();

        //7. Click to “Purchase Foreign Currency”
            driver.findElement(By.partialLinkText("Purchase")).click();

        //8. Select "Eurozone (euro) from “Currency” drop down menu
            WebElement currencymenu= driver.findElement(By.cssSelector("#pc_currency"));

            Select select=new Select(currencymenu);

        //Now Let's select with "EUR" value
            select.selectByValue("EUR");

        //9. Verify "Eurozone (Euro)" selected or not?

            SoftAssert soft=new SoftAssert();
            String expectedselection="Eurozone (euro)";
            String actualselection=select.getFirstSelectedOption().getText();

            soft.assertEquals(actualselection,expectedselection,"İt is not true");
        /*Verify Dropdown menu has these selection. "Select  One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)
         */

            List<WebElement> dropdownmenu=select.getOptions();

                for (WebElement w:dropdownmenu) {
                        System.out.println(w.getText());
                 }
                List<String> actuallist=new ArrayList<>();
            for (WebElement each: dropdownmenu) {
                actuallist.add(each.getText());
                }

            String expected[]={"Select  One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
            List<String> expectedlist=new ArrayList<>();
            expectedlist.addAll(Arrays.asList(expected));
            System.out.println("=======================888888888888888888======================");

            for (String w:expectedlist) {
                System.out.println(w.toString());
                 }
            System.out.println("======================00000000000000000000000==========================");


            for (String w: expected) {
            System.out.println(w.toString());
            soft.assertTrue(actuallist.contains(w.toString()),"Maalesef");
                }
        soft.assertAll();
    }
}
