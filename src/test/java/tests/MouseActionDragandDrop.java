package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

public class MouseActionDragandDrop extends TestBaseClass {

    /*
    MouseActions2
    1- Go to https://demoqa.com/droppable address
    2- Drag the “Drag me”  and put “Drop here” box
    3- Test the “Dropped!” text
     */

    @Test
        public void dragandDroptest() {

            driver.get("https://demoqa.com/droppable");
             Actions action=new Actions(driver);
                WebElement dragBox=driver.findElement(By.cssSelector("#draggable"));
                WebElement dropBox= driver.findElement(By.cssSelector("#droppable"));
                action.dragAndDrop(dragBox,dropBox).perform();
                WebElement droppedText=driver.findElement(By.xpath("//p[text()='Dropped!']"));

            Assert.assertTrue(droppedText.isDisplayed());

            System.out.println("The text is=========>>> " +droppedText.getText());
    }
    /*
        1- Go to https://www.amazon.com/ address
        2- Hold on  “Account & Lists”
        3- Click to “Create a list” button
        4- Test at the new page “Your Lists” text is displayed
     */
    @Test
        public void moveToElement() {
            driver.get("https://www.amazon.com/");
            Actions action=new Actions(driver);
                WebElement targetArea= driver.findElement(By.id("nav-link-accountList"));
                action.moveToElement(targetArea).perform();
            driver.findElement(By.xpath("//span[text()='Create a List']")).click();
                WebElement yourListtext=driver.findElement(By.xpath("//div[@role='heading']"));
            Assert.assertTrue(yourListtext.isDisplayed());
    }
}
