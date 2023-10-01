package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
   /* 1) Browser açın
2) “http://practice.automationtesting.in/” adresine gidin
            3) Sİtenin başlığını alıp yazdırın
4) Sitenin url adresini alıp yazdırın
5) Başlığın Practice ve Url'in  ise practice içerip içermediğini test edin
            6) Pencereyi kapatın

    */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // 1) Browser açın

       // 2) “http://practice.automationtesting.in/” adresine gidin
        driver.get("https://practice.automationtesting.in/");

       // 3) Sİtenin başlığını alıp yazdırın
        System.out.println(driver.getTitle());
        // 4) Sitenin url adresini alıp yazdırın
        System.out.println(driver.getCurrentUrl());
       // 5) Başlığın Practice ve Url'in  ise practice içerip içermediğini test edin
        if (driver.getTitle().contains("Practice")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        if (driver.getCurrentUrl().contains("practice")){
            System.out.println("URL practice kelimesi iceriyor= Test passed");
        }else {
            System.out.println("URL practice icermiyor= Test failed");
        }
       // 6) Pencereyi kapatın
        Thread.sleep(10000);
        driver.close();


    }
}
