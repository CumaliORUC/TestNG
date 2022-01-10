package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

public class TestBase_WindowsHandle extends TestBaseClass {
  /*
        Go to "https://the-internet.herokuapp.com/iframe"
        Click to Elemental Selenium
        Got 2nd page Write to console Sauce Labs
   */
    @Test
        public void test01() {

            driver.get("https://the-internet.herokuapp.com/iframe");
            WebElement Elemental_Selenium=driver.findElement(By.partialLinkText("Selenium"));
            String link=Elemental_Selenium.getAttribute("href"); //get new page address with getattribute
            System.out.println(link);
            driver.get(link);    //driver take second web page addresse (link)
            WebElement SauceLab=driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
            System.out.println("Result text =====>" +SauceLab.getText());

    }
}
