package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Iframe {
     /*
        ● https://the-internet.herokuapp.com/iframe adresine gidin.
        ● method name iframeTest
            ○ Test “An IFrame containing….” text isenabled and write on console
            ○ Write on Text Box “Hello world!”
            ○ TextBox’in altinda bulunan “Elemental Selenium”
            linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
     */
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
        public void iframetest () {
            driver.get("https://the-internet.herokuapp.com/iframe");
            SoftAssert soft=new SoftAssert();

            //Test “An IFrame containing….” text isenabled and write on console
            WebElement Iframetext=driver.findElement(By.xpath("//h3"));
            String text=Iframetext.getText();
            soft.assertTrue(Iframetext.isEnabled(),"1");
            System.out.println(text);
            //Write on Text Box “Hello world!”

            WebElement iframelocation= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
                driver.switchTo().frame("mce_0_ifr"); //enter the ıframe
                WebElement textbox=driver.findElement(By.xpath("//p"));
                textbox.clear(); //first we should clear inside message
                textbox.sendKeys("Hello World");
                WebElement typedtext= driver.findElement(By.cssSelector("#tinymce"));
            System.out.println(typedtext.getText());
            soft.assertTrue(typedtext.getText().equals("Hello World"),"2");

            driver.switchTo().parentFrame(); //exit from ıframe
            // TextBox’in altinda bulunan “Elemental Selenium linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

            WebElement seleniumtext=driver.findElement(By.partialLinkText("Selenium"));
            soft.assertTrue(seleniumtext.isDisplayed(),"3");
            System.out.println(seleniumtext.getText());

            soft.assertAll();

    }

}
