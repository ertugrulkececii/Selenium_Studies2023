package grupcalismalari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G02 {
    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        //2- https://www.automationexercise.com/ adresine gidin
        //3- Category bolumundeki elementleri locate edin
        // 4- Category bolumunde 3 element oldugunu test edin
        // 5- Category isimlerini yazdirin
        // 6- Sayfayi kapatin

        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");

        List<WebElement> liste = driver.findElements(By.className("panel-title"));
        System.out.println(liste.size());
        int Expected = 3;
        int actual = liste.size();
        if (Expected == actual) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        for (WebElement each : liste
        ) {
            System.out.println(each.getText());
        }
        Thread.sleep(3000);
        driver.close();
    }
}
