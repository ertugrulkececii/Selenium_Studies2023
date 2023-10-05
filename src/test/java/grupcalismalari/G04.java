package grupcalismalari;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class G04 extends TestBase {

    @Test
    public void test01(){

        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//*[@name='login']"));
                                                ////*[@id='email']
    }
}
