package Day_11_040123;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_GoogleSearchTestNG {
    WebDriver driver;

    @BeforeSuite
    public void setUpDriver(){
        driver = ReusableMethods.defineChromeDriver();

    }//end of before suite

    @Test
    public void GoogleSearchNumber(){
        driver.navigate().to("https://www.google.com");
        ReusableMethods.sendKeysMethod(driver,"//*[@name='q']","BMW", "Search Field");
        ReusableMethods.submitMethod(driver,"//*[@name='btnK']", "Google Search");
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for BMW: " + arrayResult[1]);
    }// end of test

    //quit the driver
    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite
}//end of class
