package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P06 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
    @Test
    public void test01(){
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Anasayfa Görüntülendi");
        }else{
            System.out.println("Anasayfaya ulaşılamadı");
        }
        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Verify 'New User Signup!' is visible
        String expectedMessage="New User Signup!";
        String actualMessage= driver.findElement(By.xpath("//*[text()='New User Signup!']")).getText();
        if (expectedMessage.equals(actualMessage)){
            System.out.println("Yeni Kayıt Bölümü Görüntülendi");
        }else{
            System.out.println("Yeni Kayıt Bölümüne ulaşılamadı");
        }
        //    6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("Ertugrul1");
               driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ertugrul@ertuu.com");
      //  driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Ertugrul1");
        //driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("ertugrul@ertuu.com");
        //    7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        //    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String expectedMessage2="Enter Account Information";
        String actualMessage2=driver.findElement(By.xpath("//*[text()='Enter Account Information']")).getText();
        if (expectedMessage2.equals(actualMessage2)){
            System.out.println("Information Bölümü Görüntülendi");
        }else{
            System.out.println("Information ulaşılamadı");
        }
        //    9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("Ertuu1.");
        driver.findElement(By.xpath("//select[@data-qa='days']")).sendKeys("4");
        driver.findElement(By.xpath("//select[@data-qa='months']")).sendKeys("JAN");
        driver.findElement(By.xpath("//select[@data-qa='years']")).sendKeys("1992");
        //    10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();
        //    11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();
        //    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("ERtuu");
        driver.findElement(By.xpath("//*[@data-qa='last_name']")).sendKeys("Osmanoglu");
        driver.findElement(By.xpath("//*[@data-qa='address']")).sendKeys("Bakirkoy");
        driver.findElement(By.xpath("//*[@data-qa='country']")).sendKeys("Holland");
        driver.findElement(By.xpath("//*[@data-qa='state']")).sendKeys("Non USA");
        driver.findElement(By.xpath("//*[@data-qa='city']")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//*[@data-qa='zipcode']")).sendKeys("34647");
        driver.findElement(By.xpath("//*[@data-qa='mobile_number']")).sendKeys("903334445561");
        //    13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //    14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedMessage3="Account Created!";
        String actualMessage3=driver.findElement(By.xpath("//*[text()='Account Created!']")).getText();
        if (expectedMessage3.equals(actualMessage3)){
            System.out.println("Hesap başarıyla oluşturuldu");
        }else{
            System.out.println("Hesap oluşturulamadı");
        }
        //    15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //    16. Verify that 'Logged in as username' is visible

        //    17. Click 'Delete Account' button
        driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        //    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }
}
