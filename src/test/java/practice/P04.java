package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
     /* ...Exercise3...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
  */
     public static void main(String[] args) throws InterruptedException {
         System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
         WebDriver driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
         driver.findElement(By.id("calculatetest")).click();
         driver.findElement(By.id("number1")).sendKeys("20");
         driver.findElement(By.id("number2")).sendKeys("60");
         driver.findElement(By.id("calculate")).click();
         System.out.println("20+60= "+driver.findElement(By.id("answer")).getText());
Thread.sleep(10000);
driver.close();

     }
}
