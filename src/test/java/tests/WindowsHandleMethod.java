package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

import java.util.Set;

public class WindowsHandleMethod extends TestBaseClass {
    /*
        Go to "https://the-internet.herokuapp.com/iframe"
        Click to Elemental Selenium
        Got 2nd page Write to console Sauce Labs
   */
    @Test
         public void test01() {

             driver.get("https://the-internet.herokuapp.com/iframe");
             WebElement Elemental_Selenium=driver.findElement(By.partialLinkText("Selenium"));
             String firstpageHandleValue= driver.getWindowHandle();
             Elemental_Selenium.click();

            Set<String> allpageHandleValues=driver.getWindowHandles();

            String secondpageHandleValue="";
            for (String each: allpageHandleValues) {

                if (!each.equals(firstpageHandleValue)) {
                secondpageHandleValue=each;
                }
            }
            driver.switchTo().window(secondpageHandleValue);
            WebElement SauceLab=driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
            System.out.println("Result text =====>" +SauceLab.getText());

    }
}