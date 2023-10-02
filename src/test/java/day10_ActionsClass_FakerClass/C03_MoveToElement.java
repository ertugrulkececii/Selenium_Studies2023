package day10_ActionsClass_FakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){
//1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
//2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement accountlist=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountlist).perform();
        //3- “Create a list” butonuna basin
        WebElement createMenu=driver.findElement(By.xpath("//span[normalize-space()='Create a List']"));
        createMenu.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListYazisi=driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListYazisi.isDisplayed());

    }
}
