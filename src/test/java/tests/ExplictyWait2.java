package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import static org.testng.Assert.*;


public class ExplictyWait2 extends TestBaseClass {
    /*

 enableTest()
3. https://demoqa.com/dynamic-properties adresine gidin.
4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
6. Bir metod olusturun : visibleTest()
7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
ve gorunur oldugunu test edin
     */
    @Test
        public void eanbleTest() {
            driver.get("https://demoqa.com/dynamic-properties");

            WebElement enableAfter=driver.findElement(By.cssSelector("#enableAfter"));

                assertFalse(enableAfter.isEnabled());
            WebDriverWait wait=new WebDriverWait(driver,5);

            WebElement enableAfterActive=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#enableAfter")));

                assertTrue(enableAfterActive.isEnabled());
    }
    @Test
        public  void visibiltyTest() {

            driver.get("https://demoqa.com/dynamic-properties");

            WebDriverWait wait=new WebDriverWait(driver,7);

            WebElement visibileAfter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));

                assertTrue(visibileAfter.isDisplayed());
    }
}
