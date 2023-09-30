package day09_iframe_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void test01(){
        ////1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement cookiesIFrame= driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.xpath("//*[text()='Tümünü Kabul Et']")).click();
        ////2) sayfadaki iframe sayısını bulunuz.
        ////3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        ////4) ilk iframe'den çıkıp ana sayfaya dönünüz
        ////5) ikinci iframe'deki (Jmeter Made Easy) linke
        ////   (https://www.guru99.com/live-selenium-project.html) tıklayınız
    }
}
