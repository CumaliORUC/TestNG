package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

/*
    KeyboardActions2
2- https://html.com/tags/iframe/
3- Pulldown the page to Youtube Video
4- Play the video
5- Test the video is playing

 */
public class KeyboardAction extends TestBaseClass {
    @Test
        public void keyboardpractise () {
            driver.get("https://html.com/tags/iframe/");
                Actions action=new Actions(driver);
                    action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

                    WebElement frame= driver.findElement(By.className("lazy-loaded"));
                    driver.switchTo().frame(frame);
                    WebElement playbutton= driver.findElement(By.xpath("//button[@class='ytp-button ytp-title-notifications']"));
                    playbutton.click();

    }
}
