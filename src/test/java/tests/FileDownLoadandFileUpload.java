package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

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

            assertTrue(Files.exists(Path.of(AppiumPath)));

    }

    /*
    2. https://the-internet.herokuapp.com/upload
    3. Cliclk to chooseFile button
    4. Slect folder from your Downloads folder
    5. Upload butonuna basalim.
    6. Test the “File Uploaded!” text is seen.
     */
    @Test
        public void fileUpLoad() {
            driver.get("https://the-internet.herokuapp.com/upload");
            WebElement chooseFileButton=driver.findElement(By.xpath("//input[@id='file-upload']")) ;
            // WARNING!!! Sendkeys code uses without click to ChooseFileButton
            String mainPath=System.getProperty("user.home");
            String AppiumPath=mainPath+"\\Downloads\\Appium.txt"; //Appium path from download folder
            chooseFileButton.sendKeys(AppiumPath);

            driver.findElement(By.cssSelector(".button")).click(); //click to Upload button
            WebElement FileUploadedElement=driver.findElement(By.tagName("h3"));

            assertTrue(FileUploadedElement.isDisplayed());

    }

}
