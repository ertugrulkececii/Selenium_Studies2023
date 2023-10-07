package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P09 {

    /*    Exercise-1:

BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
http://www.qooqle.com adresine gidin
1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin
AfterClass ile kapatin.
*/
    static WebDriver driver;
    static WebElement searchbox;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Before
    public void before() {
        driver.get("http://www.google.com");

        searchbox = driver.findElement(By.xpath("//*[@id='APjFqb']"));

    }

    @After
    public void after() {
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());
    }

    @Test
    public void angryMan() {
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();
        searchbox.sendKeys("12 Angry Men" + Keys.ENTER);
    }

    @Test
    public void vizontele() {
        searchbox.sendKeys("Vizontele" + Keys.ENTER);
    }

    @Test
    public void Ryan() {
        searchbox.sendKeys("Saving Private Ryan" + Keys.ENTER);
    }
}
