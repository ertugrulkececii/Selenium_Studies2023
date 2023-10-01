package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P05 extends TestBase {
    /*
    1-Driver oluşturalim
    2-Java class'imiza chnomedriver. exetyi tanitalim
    3-Driver'in tum ekranı kaplamasini saglayalim
    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
     Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
    5-Navigate to http://www.babayigit.net/murat/testpage.html
    6-first name, surname, age, Your Job, Birth Palace, Last graduated from school, Number of Children
        alanlarına gerekli bilgileri yazsın
    7-Submit tuşuna bassın.
    8- All information was entered correctly. yazısının göründüğünü test etsin ve yazan yazıyı yazdırsın
    9- Clear butonu ile tüm alanları temizlesin
    10- Manuel olarak temizlendiğini görecek kadar beklesin
    11- Sayfayı kapatsın

     */
    @Test
    public void navigate (){
        driver.get("http://www.babayigit.net/murat/testpage.html");
        driver.findElement(By.id("ad")).sendKeys("Ertugrul");
        driver.findElement(By.id("soyad")).sendKeys("Yigitoglu");
        driver.findElement(By.id("yas")).sendKeys("35");
        driver.findElement(By.id("meslek")).sendKeys("Yamak");
        driver.findElement(By.name("dogum_yeri")).sendKeys("Istanbul");
        driver.findElement(By.id("mezun_okul")).sendKeys("Uludag University");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("0");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        String expextedResult="All information was entered correctly..";
        String actualResult=driver.findElement(By.xpath("//p[text()='All information was entered correctly..']")).getText();
        if (expextedResult.equals(actualResult)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
    }
}
