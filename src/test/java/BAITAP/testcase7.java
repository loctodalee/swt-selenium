package BAITAP;

import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/*
1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link
 */
@Test
public class testcase7 {
    public static void Testtestcase7() {
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            //1. Go to http://live.techpanda.org/
            SoftAssert softassert= new SoftAssert();
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
            driver.findElement(By.xpath("//a[contains(@title,'Log In')]")).click();

            //3. Login in application using previously created credential
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAccount("loc@gmail.com","123456789");

            //4. Click on 'My Orders'
            driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();

            //5. Click on 'View Order'
            driver.findElement(By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]")).click();

            //6. Click on 'Print Order' link
            driver.findElement(By.xpath("//a[@class='link-print']")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
