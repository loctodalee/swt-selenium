package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    private WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }
    public void fillBilling (){
        try {
            Select sAddr = new Select(driver.findElement(By.name("billing_address_id")));
            int sAddrSize = sAddr.getOptions().size();
            sAddr.selectByIndex(sAddrSize - 1);
        } catch (Exception e){
            System.out.println("Bliing drop down error ");
        }

        driver.findElement(By.xpath("//input[@id='billing:firstname']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='billing:middlename']")).sendKeys("Soft");
        driver.findElement(By.xpath("//input[@id='billing:lastname']")).sendKeys("Ware");
        driver.findElement(By.xpath("//input[@id='billing:company']")).sendKeys("FPT");
        driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("123 ABC");
        driver.findElement(By.xpath("//input[@id='billing:street2']")).sendKeys("456 ABC");
        driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("United States");
        WebElement selectCountry = driver.findElement(By.xpath("//select[@id='billing:country_id']"));
        Select checkoutCountry = new Select(selectCountry);
        checkoutCountry.selectByValue("US");

        WebElement region = driver.findElement(By.xpath("//select[@id='billing:region_id']"));
        Select regionSelect = new Select(region);
        regionSelect.selectByValue("2");
        driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//input[@id='billing:fax']")).sendKeys("123456789");
        driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']")).click();
    }
    public void fillShipping (){
        try {
            Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
            int sAddrSize = sAddr.getOptions().size();
            sAddr.selectByIndex(sAddrSize - 1);
        } catch (Exception e){
            System.out.println("shipping drop down error ");
        }
        driver.findElement(By.xpath("//input[@id='shipping:firstname']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:firstname']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='shipping:middlename']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:middlename']")).sendKeys("Soft");
        driver.findElement(By.xpath("//input[@id='shipping:lastname']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:lastname']")).sendKeys("Ware");
        driver.findElement(By.xpath("//input[@id='shipping:company']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:company']")).sendKeys("FPT");
        driver.findElement(By.xpath("//input[@id='shipping:street1']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:street1']")).sendKeys("123 ABC");
        driver.findElement(By.xpath("//input[@id='shipping:street2']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:street2']")).sendKeys("456 ABC");
        driver.findElement(By.xpath("//input[@id='shipping:city']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:city']")).sendKeys("United States");
        WebElement selectedCountry = driver.findElement(By.xpath("//select[@id='shipping:country_id']"));
        Select checkout = new Select(selectedCountry);
        checkout.selectByValue("US");

        WebElement regioned = driver.findElement(By.xpath("//select[@id='shipping:region_id']"));
        Select selectedRegion = new Select(regioned);
        selectedRegion.selectByValue("2");
        driver.findElement(By.xpath("//input[@id='shipping:postcode']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:postcode']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@id='shipping:telephone']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:telephone']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//input[@id='shipping:fax']")).clear();
        driver.findElement(By.xpath("//input[@id='shipping:fax']")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@onclick='shipping.save()']")).click();
    }
}
