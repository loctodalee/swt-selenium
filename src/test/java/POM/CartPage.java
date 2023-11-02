package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cartPage (){
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select countrySelect = new Select(country);
        countrySelect.selectByValue("US");

        WebElement state = driver.findElement(By.xpath("//select[@id='region_id']"));
        Select stateSelect = new Select(state);
        stateSelect.selectByValue("2");
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("1111");
    }
}
