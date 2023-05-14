package ActionItems;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Automation_AI05 extends ReusableAnnotations {
        @Test
        public void Automation_AI05() throws InterruptedException {
        //navigate to Best-buy
        driver.navigate().to("https://www.bestbuy.com/");
        //search airpods
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@class='search-input']", "airpods", logger, "type in search");
        //get an error without this Thread.sleep
        Thread.sleep(2000);
        ReusableMethods_Logger.clickMethod(driver, "//*[@aria-label='submit search']", logger, "search");
        //click on best-selling by text
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='tb-select']", logger, "click sort by");
        ReusableMethods_Logger.selectByText(driver, "//*[@class='tb-select']", "Best Selling", "best selling");
        //click on first airpods
        ReusableMethods_Logger.clickMethodByIndex(driver, "//*[@class='sku-title']", 1, logger, "click airpods");
        //scroll to learn about totaltech
        ReusableMethods_Logger.scrollByElement(driver, "//*[text()='Learn About Totaltech']", logger, "scroll");
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='fulfillment-add-to-cart-button']", logger, "add to cart");
        //split the array to print total
        String result = ReusableMethods_Logger.captureTextMethod(driver, "//*[@class='shop-cart-subtotal']", logger, "capture text");
        String[] arrayResult = result.split(" ");
        System.out.println(arrayResult[3]);
        }
}
