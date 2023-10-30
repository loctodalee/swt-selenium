package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShareWishListPage {
    private WebDriver driver;

    public ShareWishListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void EnterWishList (String Email, String message){
        driver.findElement(By.id("email_address")).sendKeys(Email);
        driver.findElement(By.id("message")).sendKeys(message);
        driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
    }
}
