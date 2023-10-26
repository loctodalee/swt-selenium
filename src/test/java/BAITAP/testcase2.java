package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/
@Test
public class testcase2 {
    public static void testTestcase2() {
        WebDriver driver = driverFactory.getChromeDriver();

      try{
          // Step 1. Go to http://live.techpanda.org/
          driver.get("http://live.techpanda.org");

          Actions actions = new Actions(driver);

          //2. Click on �MOBILE� menu
          WebElement mobile = driver.findElement(By.className("level0"));
          actions.click(mobile).perform();

          //3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
          WebElement price = driver.findElement(By.id(("product-price-1")));
          String price1 = price.getText();
          //4. Click on Sony Xperia mobile
          WebElement sony = driver.findElement(By.cssSelector("a[title='Sony Xperia']"));
          actions.click(sony).perform();

          //5. Read the Sony Xperia mobile from detail page.
          WebElement desc = driver.findElement(By.className("std"));
          System.out.println("Detail: "+desc.getText());

          // 6. Compare Product value in list and details page should be equal ($100).
          WebElement price2 = driver.findElement(By.className(("price")));
          if(price1.equals(price2.getText())){
              System.out.println("Equals");
          }else {
              System.out.println("Not equals");
          }

      }catch (Exception e){
          e.printStackTrace();
      }
      driver.quit();
    }

}
