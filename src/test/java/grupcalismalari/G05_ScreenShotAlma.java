package grupcalismalari;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class G05_ScreenShotAlma extends TestBase {

    @Test
    public void test01() throws IOException {
//1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
// 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        WebElement amazonSayfaKontrol = driver.findElement(By.xpath("//*[@*='nav-link-accountList-nav-line-1']"));
        String expected = "Hello, sign in";
        String actual = amazonSayfaKontrol.getText();
        System.out.println(amazonSayfaKontrol.getText());
        Assert.assertTrue(actual.contains(expected));
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaSS = new File("target/screenShots/amazonTumSayfaSS.jpeg");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, tumSayfaSS);

        // 3- Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);



       // 4- sonucun Nutella icerdigini test edin.
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik ="Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        //5-ilk urunun goruntusunu alin
        WebElement ilkUrun= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        File ilkElementSshot=new File("target/screenShots/ilkElementSS.jpeg");
        File geciciResim1= ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim1, ilkElementSshot);
    }
}
