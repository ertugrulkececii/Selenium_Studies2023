package day10_ActionsClass_FakerClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_sagClick extends TestBase {


    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi=driver.findElement(By.id("By.id(\"hot-spot\")"));
        Actions actions= new Actions(driver);
        actions.click(ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        driver.switchTo().alert().accept();
        bekle(2);
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWhd = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        bekle(2);
        String ikinciSayfaWhd = "";
        Set<String> whdSeti = driver.getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd = each;
            }
        }
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedYazi2 = "Make sure your code lands";
        String actualYazi2= driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi2,actualYazi2);
    }
    }

