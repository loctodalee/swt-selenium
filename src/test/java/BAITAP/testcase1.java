/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/

package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

@Test
public class testcase1 {
    public static void testTestcase1() {
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            File destDirectory = new File("D:\\FPT\\SWT\\selenium\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\Capture");
            // Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");
            Actions actions = new Actions(driver);

            WebElement title = driver.findElement(By.className("page-title"));
            WebElement mobile = driver.findElement(By.className("level0"));


            //Step 2. Verify Title of the page
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            actions.doubleClick(title).perform();
            File screenshot1 = screenshot.getScreenshotAs(OutputType.FILE);
            File checkTitle = new File(destDirectory, "TC1-title.png");
            FileHandler.copy(screenshot1, checkTitle);


            //Step 3. Click on -> MOBILE -> menu
            actions.click(mobile).perform();

            //Step 4. In the list of all mobile , select SORT BY -> dropdown as name
            WebElement sort = driver.findElement(By.tagName("select"));
            Select select = new Select(sort);
            select.selectByIndex(1);

            List<WebElement> productNames = driver.findElements(By.className("product-name"));
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);

            //Step 5. Verify all products are sorted by name

            File destFile = new File(destDirectory, "TC1-sort.png");
            FileHandler.copy(srcFile, destFile);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}