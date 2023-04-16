package Day_11_040123;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//use priority if the test cases are independent of each other
//use dependsOnMethod for test cases that depend on each other
public class T2_Priorities {
    WebDriver driver;

    @Test()
    public void GoogleSearchNumber() {
        driver.navigate().to("https://www.google.com");
        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");
        ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
    }

    @Test(priority = 1)
    public void captureSearch(){
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for BMW: " + arrayResult[1]);
    }// end of test


    @BeforeSuite
    public void setUpDriver(){
        driver = ReusableMethods.defineChromeDriver();

    }//end of before suite

    @Test(priority = 2)
    public void clickOnFinance() {
        ReusableMethods.clickMethod(driver," //div[text()='Finance']","Finance");
    }//end of test 3

    //quit the driver
    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite
}
