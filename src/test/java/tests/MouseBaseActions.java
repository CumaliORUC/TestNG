package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utulities.TestBaseClass;

import java.util.Set;

public class MouseBaseActions extends TestBaseClass {
    /*
    1-  MouseActions1
    2- Go to https://the-internet.herokuapp.com/context_menu
    3- Right click over the rectangle
    4- Test the Alert’s text “You selected a context menu”
    5- Click to "Tamam"
    6- Click to Elemental Selenium link
    7- Test the “Elemental Selenium” text, at new window
     */
    @Test
        public void test01() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/context_menu");
            Actions action=new Actions(driver);
            WebElement rectanglearea= driver.findElement(By.id("hot-spot"));
            action.contextClick(rectanglearea).perform();
            String actualAlertText=driver.
                                    switchTo().
                                    alert().
                                    getText();
            String expectedAlerText="You selected a context menu";

            SoftAssert soft=new SoftAssert();
            soft.assertEquals(actualAlertText,expectedAlerText,"They are nı-ot the eguals");
            Thread.sleep(4000);

            driver.switchTo().alert().accept();
            action.click(rectanglearea).perform(); //to close rightclick window
                driver.findElement(By.linkText("Elemental Selenium")).click();
                String frstpageWindowHandle= driver.getWindowHandle();
                String secondpagewindowHandle="";

            Set<String> windowsHandlepages=driver.getWindowHandles();

            for (String each:windowsHandlepages) {
                if (!each.equals(frstpageWindowHandle)) {
                secondpagewindowHandle=each;
                }

            }
            driver.switchTo().window(secondpagewindowHandle);
                WebElement ElementalSeleniumText= driver.findElement(By.xpath("//h1"));

                String expectedElementalText="Elemental Selenium";
                String actualElementalText= ElementalSeleniumText.getText();

            soft.assertEquals(actualElementalText,expectedElementalText,"They are diffirent");

            soft.assertAll();
    }
}
