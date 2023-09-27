package grupcalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class G01 {

    public static void main(String[] args) {



        //6- Bulunan sonuc sayisini yazdirin
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8- Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        ReusableMethods.bekle(2);

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class ='QS5gu sy4vM'])[2]")).click();

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTittle="Google";
        String actuallTitle = driver.getTitle();

        if (actuallTitle.contains(expectedTittle)) {
            System.out.println("Tittle test is PASSED");
        } else {
            System.out.println("Tittle test is FAILED");

        }
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.click();
        //5- Arama cubuguna “Nutella” yazip aratin
       searchBox.sendKeys("nutella"+ Keys.ENTER);


    }
}
