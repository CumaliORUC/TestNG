package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;

public class ActionsKeysandTab extends TestBaseClass {

    @Test
        public void FacebookKeysAction () throws InterruptedException {

            driver.get("https://www.facebook.com");
                Actions action=new Actions(driver);
                WebElement newAccount= driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']"));
                action.click(newAccount).perform();

            //now we are at second page we will pass the next tabs with Keystab

                WebElement firstname= driver.findElement(By.name("firstname"));

                    action.sendKeys(firstname,"Charlie"
                        +Keys.TAB,"Brown"
                        +Keys.TAB,"charliebrown@gmail.com"
                        +Keys.TAB,"Charlie1"
                        +Keys.TAB, "Charlie1").perform();

                WebElement birthDay= driver.findElement(By.name("birthday_day")); //birthday
                    Select selectDay=new Select(birthDay);
                        selectDay.selectByVisibleText("8");

                    Select selectMounth=new Select(driver.findElement(By.name("birthday_month"))); //birthmounth
                        selectMounth.selectByValue("5");

                    Select selectYear=new Select(driver.findElement(By.name("birthday_year")));  //birthyear
                        selectYear.selectByValue("2007");

              driver.findElement(By.xpath("//label[text()='Erkek']")).click();

              driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();  //sign-in button
    }

    @ Test
            /*
            Writing "samsung A71" with actions at amazon search box push the Enter and verify results
             basarak arama yaptirin
             */
        public void amazonKeysUp() {
            driver.get(" https://www.amazon.com");
                WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
                Actions action=new Actions(driver);
                    action.sendKeys(searchbox,"samsung ")
                                    .keyDown(Keys.SHIFT)
                                    .sendKeys("a")
                                    .keyUp(Keys.SHIFT)
                                    .sendKeys("71"+Keys.ENTER)
                                    .perform();
                String expectedTitle="samsung A71";
                String actualTitle=driver.getTitle();

            Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
