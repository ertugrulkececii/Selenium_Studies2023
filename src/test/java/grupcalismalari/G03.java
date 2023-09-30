package grupcalismalari;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

import java.time.Duration;

public class G03 extends TestBase_BeforeClass {
    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //kontrol edin.
    @Before
    public void islemler() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username");  //user_password
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("(//a[normalize-space()='More Services'])[1]")).click();
        driver.findElement(By.xpath("(//span[@id='pay_bills_link'])[1]")).click();
        driver.findElement(By.cssSelector("a[href='#ui-tabs-3']")).click();
    }
     @After
    public void calculate() {
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("25");
        driver.findElement(By.xpath("//label[normalize-space()='Selected currency']")).click();
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expected = "Foreign currency cash was successfully purchased.";
        WebElement actual1 = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String actual = actual1.getText();
        Assert.assertTrue(actual.contains(expected));
    }
    @Test
    public void dropdownSelect() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropdown);
        select.selectByIndex(6);


    }
}
