package day10_ActionsClass_FakerClass;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05 extends TestBase {

    @Test
    public void test01(){
//1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
//2- Cookies kabul edin
        driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
//3- Yeni hesap olustur butonuna basalim
driver.findElement(By.xpath("//a[@data-testid='Yeni hesap oluştur']"));
//4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
//5- Kaydol tusuna basalim



    }
}
