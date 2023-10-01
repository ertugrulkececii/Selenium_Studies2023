package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01 {
    public static void main(String[] args) {
        /*
   /....Exercise-1:...
    Create a new class with main method
    Set Path
    Create a chrome driver
    Maximize window
    Open google home page https://www.google.com
    On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
    Wait about 4 sn
    Navigate forward to amazon
    Refresh page
    Close/quit the browser
    And Last step print "All is well" on console
  */
        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();





    }
}
