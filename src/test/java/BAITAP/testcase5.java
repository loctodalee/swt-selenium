package BAITAP;
/*
--------------------------------TESTCASE05--------------------------------------

The next scenario is “Verify you can create account in E-commerce site and can share wishlist to other people using email”

Detailed Test Case is below

/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.
 */
import POM.RegisterPage;
import POM.ShareWishListPage;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
@Test
public class testcase5 {
    public static void Testtestcase5(){
        File destDirectory = new File("D:\\FPT\\SWT\\selenium\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\Capture");
        WebDriver driver = driverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            driver.findElement(By.className("skip-account")).click();
            driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']")).click();

            //3. Click Create an Account link and fill New User information excluding the registered Email ID.
            RegisterPage registerPage = new RegisterPage(driver);
            String firstName = "Le";
            String middleName = "Tan";
            String lastName = "Loc";
            String email = "letanloc@gmail.com";
            String password = "123456789";
            String confirm = password;

            //4. Click Register
            registerPage.register(firstName,middleName,lastName,email,password,confirm);


            //5. Verify Registration is done. Expected account registration done.
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File screenshot1 = screenshot.getScreenshotAs(OutputType.FILE);
            File checkRegister = new File(destDirectory, "TC5-Register.png");
            FileHandler.copy(screenshot1, checkRegister);

            //6. Go to TV menu
            driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();

            //7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[3]/ul[1]/li[1]/a[1]")).click();

            //8. Click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

            //9. In next page enter Email and a message and click SHARE WISHLIST
            ShareWishListPage wishListPage = new ShareWishListPage(driver);
            wishListPage.EnterWishList(email,"Test");

            //10.Check wishlist is shared. Expected wishlist shared successfully.
            File screenshot2 = screenshot.getScreenshotAs(OutputType.FILE);
            File checkShareWishList = new File(destDirectory, "TC5-ShareWishList.png");
            FileHandler.copy(screenshot2, checkShareWishList);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
