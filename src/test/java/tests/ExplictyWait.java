package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import static org.testng.Assert.*;


public class ExplictyWait extends TestBaseClass {
    /*
    EnableTest
1. Bir metod olusturun : isEnabled()
2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
3. Test the Textbox is not active
4. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
6. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */

    @Test
    public void ExplictyWaitsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
            assertFalse(textBox.isEnabled());

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait=new WebDriverWait(driver,5);

            WebElement textboxActive=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

            WebElement ItsEnabled=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));

            assertTrue(ItsEnabled.isDisplayed());

            assertTrue(textBox.isEnabled());

    }
}
