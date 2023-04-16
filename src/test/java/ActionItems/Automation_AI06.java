package ActionItems;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;
public class Automation_AI06 extends ReusableAnnotations {
    //test #1
    @Test
    public void navigate() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org");
        //clicks on search element top right
        ReusableMethods.clickMethod(driver, "//*[@class='fal fa-search']", "Search");
        //enters get dental coverage
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "get dental coverage", "Search get field");
        ReusableMethods.clickMethod(driver, "//*[@aria-label='Execute Search']", "Hit Search");
        //string to capture the search results
        String result = ReusableMethods.captureTextMethod(driver,"//*[@class='gsc-result-info']", "Capture Search results");
        //split the result string
        String[] arrayResult = result.split(" ");
        //prints the result only
        System.out.println("Search number for Dental plans: " + arrayResult[1]);
        ReusableMethods.clickMethod(driver, "//*[text()='Get Dental Coverage']", "Dental Coverage");
    }
    //second test that depends on navigate test
    @Test(dependsOnMethods = "navigate")
    public void fillOutForm() throws InterruptedException {
        //switch driver to second tab
        ReusableMethods.switchToTabByIndex(driver, 1, "Switch Tabs");
        //below lines enters all my information
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "Joy", "Enter first name");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Biswas", "Enter last name");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "10462", "Enter zipcode ");
        ReusableMethods.selectByText(driver, "//*[@id='county']", "Bronx", "Select county");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='phoneNumber']", "3475556758", "Enter Phone number ");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='email']", "something@yahoo.com", "Enter Email ");
        //clicks on checkbox
        ReusableMethods.clickMethod(driver, "//*[@for='contactMe']", "checkbox");
        //click on contact me button
        ReusableMethods.clickMethod(driver, "//*[@type='submit']", "Contact me");
        //captures the message as string
        String thankYouMessage = ReusableMethods.captureTextMethod(driver, "//*[@class='alert alert-success']", "Capture message");
        System.out.println(thankYouMessage);
        //close current tab
        driver.close();
        //Thread.sleep(5000);
    }
    //third test that runs only if the other two run
    @Test(dependsOnMethods = {"fillOutForm","navigate"})
    public void login() throws InterruptedException {
        //switch driver back to the first tab
        ReusableMethods.switchToTabByIndex(driver, 0, "Switch tabs");
        ReusableMethods.clickMethod(driver, "//*[@class='tool dropdown login']", "Login");
        //without this Thread sleep I get an error
        Thread.sleep(2000);
        ReusableMethods.clickMethod(driver, "//*[@class='link-external']", "Member online portal");
        //switch driver to new tab
        ReusableMethods.switchToTabByIndex(driver,1, "switch tabs");
        //captures helpful hints as a string
        String helpfulHints = ReusableMethods.captureTextMethod(driver, "//*[@class='card']", "Capture hints");
        System.out.println(helpfulHints);
        driver.close();
    }

}