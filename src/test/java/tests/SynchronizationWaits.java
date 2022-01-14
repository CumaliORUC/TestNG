package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import static org.testng.Assert.assertTrue;

public class SynchronizationWaits extends TestBaseClass {
    /*
    1. Execute two test with implicitWait() , explicitWait()
    2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    3. Click to Remove button
    4. Test the “It’s gone!” text is displayed
    5. Click to Add
    6. Test the It’s back! text is displayed
     */
    @Test
        public void implicityWait() {
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            driver.findElement(By.xpath("//*[text()='Remove']")).click(); //Click to Remove Button
            WebElement Itsgone= driver.findElement(By.xpath("//p[@id='message']")); //If we delete Implicitywait from TestBaseClass, this method will fail.

                assertTrue(Itsgone.isDisplayed());

            driver.findElement(By.xpath("//*[text()='Add']")).click(); //Click to Add Button
            WebElement ItisBack=driver.findElement(By.cssSelector("p#message"));
                assertTrue(ItisBack.isDisplayed());  // It's Back element
    }
    @Test
        public  void ExplicityWait() {
            WebDriverWait wait=new WebDriverWait(driver,6);
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            driver.findElement(By.xpath("//*[text()='Remove']")).click();
            WebElement Itsgone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
                assertTrue(Itsgone.isDisplayed());

            driver.findElement(By.xpath("//*[text()='Add']")).click();

            WebElement Itsback=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));

                assertTrue(Itsback.isDisplayed());
    }
}
