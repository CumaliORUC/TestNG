package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Path;

/*
- Go to https://the-internet.herokuapp.com/download adress
-  Download Appium.txt document
- Test the document is downloaded?

 */
public class FileDownLoadandFileUpload extends TestBaseClass{

    @Test
        public void Filedownloadingtest() throws InterruptedException {

            driver.get("https://the-internet.herokuapp.com/download");

            WebElement Appiumdocument= driver.findElement(By.linkText("Appium.txt"));

            Appiumdocument.click();  //click for download

                String mainPath=System.getProperty("user.home");
                String AppiumPath=mainPath+"\\Downloads\\Appium.txt"; //Appium path

            Thread.sleep(6000);

            Assert.assertTrue(Files.exists(Path.of(AppiumPath)));

    }

}
