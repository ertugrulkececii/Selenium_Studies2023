package grupcalismalari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class G09_Cookies extends TestBase {

    @Test
    public void Test01() {
        //  1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //  2- Tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int siraNo = 1;
        for (Cookie each : cookieSet) {
            System.out.println(siraNo + " - " + each);
            siraNo++;
        }
        //  3- Sayfadaki cookies sayisinin 3’den buyuk oldugunu test edin
        int expectedCookiesSayisi=3;
        int actualCookiesSayisi=cookieSet.size();
        Assert.assertTrue(actualCookiesSayisi>expectedCookiesSayisi);
        //  4- ismi "skin" olan cookie degerinin "noskin" oldugunu test edin
        String expectedValue="noskin";
        String actualValue=driver.manage().getCookieNamed("skin").getValue();
        Assert.assertEquals(actualValue,expectedValue);
        //  5- ismi “the best” ve degeri “kakaolu” olan bir cookie olusturun ve sayfaya ekleyin
        //  6- Eklenen cookie’nin sayfaya eklendigini test edin
        //  7- ismi "skin" olan cookie’yi silin ve silindigini test edin
        //  8- tum cookie’leri silin ve silindigini test edin

    }
}
