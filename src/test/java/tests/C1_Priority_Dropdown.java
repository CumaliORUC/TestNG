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

public class C1_Priority_Dropdown {

    /*
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
degilse False yazdırın
     */
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
    @Test

    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownmenu= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select myselect=new Select(dropdownmenu);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
       myselect.selectByIndex(1);
        System.out.println(myselect.getFirstSelectedOption().getText());

    }

    //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test (priority = 3)
    public void test () {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownmenu= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select myselect=new Select(dropdownmenu);

        myselect.selectByValue("2");

        System.out.println(myselect.getFirstSelectedOption().getText());
    }

    // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    @Test (priority = 5)
    public void test02 () {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownmenu= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select myselect=new Select(dropdownmenu);

        myselect.selectByVisibleText("Option 1");

        System.out.println("visible olarak seçilen ------------->"+myselect.getFirstSelectedOption().getText());

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> listem=myselect.getOptions();

        for (WebElement w: listem) {
            System.out.println("Seçenek  ----------->" +w.getText());
        }


        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın
        Integer listeboyutu=listem.size();
        Integer expectedsize=4;
        Assert.assertEquals(expectedsize,listeboyutu);


}
}