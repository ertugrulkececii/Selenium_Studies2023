package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {
   protected WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();

    }
    @After
    public void teardown(){
        driver.close();
    }
    public static void bekle (int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
