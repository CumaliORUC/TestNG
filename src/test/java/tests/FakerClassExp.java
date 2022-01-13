package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.TestBaseClass;
/*
1. Go to "https://facebook.com"
2. Click to “create new account”
3. “firstName”
4. “surname”
5. “email”
6. “email”
7. "Password"
8.  Enter Birthday
9. Enter sex
10. Test the your sex is selected
11. Sayfayi kapatin
 */

public class FakerClassExp extends TestBaseClass {
    @Test
        public void test01() {
            driver.get("https://facebook.com");
            driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']")).click(); //click to new account
            Faker faker=new Faker();
            WebElement name=driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
            Actions action=new Actions(driver);
            String mail=faker.internet().emailAddress();
                action.sendKeys(faker.name().firstName())
                        .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                        .sendKeys(Keys.TAB).sendKeys(mail)
                        .sendKeys(Keys.TAB).sendKeys(mail)
                        .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                        .sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys("13")
                        .sendKeys(Keys.TAB).sendKeys("May")
                        .sendKeys(Keys.TAB).sendKeys("2003")
                        .sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();

                WebElement erkekRadioButton= driver.findElement(By.xpath("//input[@value='2']"));

                Assert.assertTrue(erkekRadioButton.isSelected());

}
}
