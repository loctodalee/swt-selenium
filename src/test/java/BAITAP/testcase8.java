package BAITAP;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/*
        *  Verify you are able to change or reorder previously added product

        *  Test Data = QTY = 10

        Test Steps:

        1. Go to http://live.techpanda.org/

        2. Click on my account link

        3. Login in application using previously created credential

        4. Click on 'REORDER' link , change QTY & click Update

        5. Verify Grand Total is changed

        6. Complete Billing & Shipping Information

        7. Verify order is generated and note the order number

        Expected outcomes:

        1) Grand Total is Changed

        2) Order number is generated
 */
@Test
public class testcase8 {
    public static void Testtestcase8(){
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
            loginPage.loginAccount("letanloc5@gmail.com","123456789");

            //4. Click on 'REORDER' link , change QTY & click Update
            ////a[@class='link-reorder']
            driver.findElement(By.xpath("//a[@class='link-reorder']")).click();
            String before = driver.findElement(By.xpath("//input[@title='Qty']")).getAttribute("value");
            String grandBefore = driver.findElement(By.xpath("//td[2]//strong[1]")).getText();
            System.out.println("Grand total before: " + grandBefore);
            System.out.println("Quantity before update: " + before);
            driver.findElement(By.xpath("//input[@title='Qty']")).clear();
            driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("15");
            driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]")).click();
            String after = driver.findElement(By.xpath("//input[@title='Qty']")).getAttribute("value");
            String grandAfter = driver.findElement(By.xpath("//td[2]//strong[1]")).getText();
            System.out.println("Grand total after: " + grandAfter);
            System.out.println("Quantity after update: " + after);

            //5. Verify Grand Total is changed
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertNotEquals(before,after);
            softAssert.assertNotEquals(grandBefore,grandAfter);

            //6. Complete Billing & Shipping Information
            CartPage cartPage = new CartPage(driver);
            cartPage.cartPage();
            driver.findElement(By.xpath("//span[contains(text(),'Estimate')]")).click();
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[2]/dl[1]/dd[1]/ul[1]/li[1]/label[1]")).click();
            driver.findElement(By.xpath("//button[@title='Update Total']")).click();
            driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();
            CheckOutPage checkOutPage = new CheckOutPage(driver);
            checkOutPage.fillBilling();
            driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

            Thread.sleep(3000);
            checkOutPage.fillShipping();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();

            driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@title='Place Order']")).click();
            Thread.sleep(1000);

            WebElement orderId = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
            System.out.println("Your order # is: " + orderId.getText());
            WebElement verify = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
            softassert.assertEquals(verify.getText(),"YOUR ORDER HAS BEEN RECEIVED.");
            softassert.assertAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
