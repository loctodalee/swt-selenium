package BAITAP;

/*
Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number
 */

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Test
public class testcase6 {
    public static void Testtestcase6(){
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

            //4. Click on MY WISHLIST link
            driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
            driver.findElement(By.xpath("//a[@title='My Wishlist']")).click();

            //5. In next page, Click ADD TO CART link
            driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
            driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();

            //6. Enter general shipping country, state/province and zip for the shipping cost estimate
            CartPage cartPage = new CartPage(driver);
            cartPage.cartPage();

            //7. Click Estimate
            driver.findElement(By.xpath("//span[contains(text(),'Estimate')]")).click();

            //8. Verify Shipping cost generated
            WebElement price = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));
            WebElement priceName = driver.findElement(By.cssSelector("dl[class='sp-methods'] dt"));
            softassert.assertEquals(priceName.getText(), "Flat Rate");
            System.out.println(priceName.getText() +": " + price.getText());

            //9. Select Shipping Cost, Update Total

            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[2]/dl[1]/dd[1]/ul[1]/li[1]/label[1]")).click();
            driver.findElement(By.xpath("//button[@title='Update Total']")).click();
            WebElement genratePrice = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)"));
            WebElement newPrice = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']//span"));

            //10. Verify shipping cost is added to total
            softassert.assertEquals(newPrice.getText(),genratePrice.getText());
            //11. Click "Proceed to Checkout"
            driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();

            //12a. Enter Billing Information, and click Continue
            CheckOutPage checkOutPage = new CheckOutPage(driver);
            checkOutPage.fillBilling();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

            Thread.sleep(3000);
            //12b. Enter Shipping Information, and click Continue
            checkOutPage.fillShipping();
            //13. In Shipping Method, Click Continue
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
            //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();

            driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

            Thread.sleep(1000);
            //15. Click 'PLACE ORDER' button
            driver.findElement(By.xpath("//button[@title='Place Order']")).click();


            Thread.sleep(1000);

            //16. Verify Oder is generated. Note the order number
            WebElement orderId = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Your order # is: " + orderId.getText());
            WebElement verify = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            softassert.assertEquals(verify.getText(),"YOUR ORDER HAS BEEN RECEIVED.");
            softassert.assertAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
