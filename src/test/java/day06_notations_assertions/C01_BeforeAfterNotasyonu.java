package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotasyonu {
    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
    WebDriver driver;
    public void setup(){
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void amazonTest(){

setup();
        driver.get("https://amazon.com");
        String expectedUrlIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("amazon testi passed");
        }else {
        System.out.println("amazon testi failed");
        }
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void wiseTitle(){
        setup();
driver.get("https://www.wisequarter.com");
String expectedTitleIcerik=("Wise");
String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("wise testi passed");
        }else {
            System.out.println("wise testi failed");
        }
        ReusableMethods.bekle(2);
        driver.close();

    }
    @Test
    public void youtubeUrlTitle(){
        setup();
driver.get("https://www.youtube.com");
        String expectedUrlTitle=("youtube");
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedUrlTitle)){
            System.out.println("youtube testi passed");
        }else {
            System.out.println("youtube testi failed");
        }
        ReusableMethods.bekle(2);
        driver.close();
    }
}
