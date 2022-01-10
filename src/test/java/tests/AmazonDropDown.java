package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDown {

    /*
    ● Bir class oluşturun: C3_DropDownAmazon
●      https://www.amazon.com/ adresine gidin.
        - Test 1
      Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
         -Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin
     */
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown () {
        driver.close();
    }

    @Test (priority = 2)
    public void test01 () {
        driver.get(" https://www.amazon.com/");
       WebElement dropdownmenu=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));  //Go to All items icon

        Select select=new Select(dropdownmenu);

        List<WebElement> allselect=select.getOptions();

        for (WebElement w: allselect) {
            System.out.println(w.getText());
        }

        Assert.assertEquals(28,allselect.size());

    }

    @Test (priority = 1)
    public  void test02() {
        driver.get(" https://www.amazon.com/");
        WebElement dropdownmenu=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));  //Go to All items icon

        Select select=new Select(dropdownmenu);

        //1. Select "Books" from all department and check it
        select.selectByVisibleText("Books");

        WebElement selectedoption=driver.findElement(By.id("nav-search-label-id"));

        Assert.assertTrue(selectedoption.getText().equals("Books"));
    }

    @Test (priority = 3)
    public  void test03() throws InterruptedException {
        /*
                2. search "Java" and write suggestions
                3. Write Results
                4. Assert Results contains "Java"
         */
        driver.get(" https://www.amazon.com/");
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Java");    //search "Java"

        List <WebElement> suggetions= driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
        Thread.sleep(3000);
        System.out.println("=================================================");

        // write suggestions

        for (WebElement w:suggetions) {
            System.out.println(w.getText()); }

        // 3. Write Results
        // 4. Assert Results contains "Java"
        searchbox.submit();

        WebElement resultnumber= driver.findElement(By.cssSelector("div.a-section.a-spacing-small.a-spacing-top-small"));

        Assert.assertTrue(resultnumber.getText().contains("Java"));

        System.out.println(resultnumber.getText());


}
}