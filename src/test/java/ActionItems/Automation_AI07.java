package ActionItems;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
//testing
public class Automation_AI07 extends ReusableAnnotations{
    @Test(priority = 1)
    public void mortgageCalculators(){
        logger.log(LogStatus.INFO,"Navigate to Citi Home page and take user to mortgage calculator");
        driver.navigate().to("https://www.citi.com");
        //declaring mouse action to hover over Lending
        Actions mouseAction = new Actions(driver);
        //xpath for lending
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        //hover over lending
        mouseAction.moveToElement(lendTab).perform();
        //click on calculator
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='mortCalc']", logger, "calculator dropdown");
        //takes you to the monthly mortage calculator
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='cta-link btn btn-link chevron-link secondary bold noMargin ng-star-inserted']", logger, "click on calculator");
    }// end of mortgage calculator test

    @Test(priority = 2)
    public void stepsToBuyAHome() throws InterruptedException {
        logger.log(LogStatus.INFO, "This test provides information to the user about the steps of buying a house");
        Actions mouseAction = new Actions(driver);
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        mouseAction.moveToElement(lendTab).perform();
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Buy a Home']", logger, "buy a home");
        WebElement steps = driver.findElement(By.xpath("//*[@class='firstLink ng-star-inserted']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",steps);
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='firstLink ng-star-inserted']", logger, "buyer's guide");
        Thread.sleep(3000);
    }//end of steps to buy a home test

    @Test(priority = 3)
    public void locationFinder() throws InterruptedException {
        logger.log(LogStatus.INFO, "This test shows the user the closest CitiBank location if they wanna apply for credit");
        Actions mouseAction = new Actions(driver);
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        mouseAction.moveToElement(lendTab).perform();
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Personal Loans & Lines of Credit']", logger, "personal loans and credit");
        WebElement applyInPerson = driver.findElement(By.xpath("//*[text()='Apply in Person']"));
        //below code scrolls to apply in person button
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",applyInPerson);
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Apply in Person']", logger, "apply in person");
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='search']", "10014", logger, "enter a location");
        Thread.sleep(2000);
        ReusableMethods_Logger.clickMethod(driver, "//*[@aria-label='Search']", logger, "submit");
        Thread.sleep(2000);
        //captures the closest location as a string
        String result = ReusableMethods_Logger.captureTextMethod(driver, "//*[@class='locations-list ng-star-inserted active-div']", logger, "print address");
        //prints out the location
        System.out.println(result);
    }//end of location class

    @Test(priority = 4)
    public void mortgageLearningCenter() throws InterruptedException {
        logger.log(LogStatus.INFO, "This test provides the user with our contact information");
        Actions mouseAction = new Actions(driver);
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        mouseAction.moveToElement(lendTab).perform();
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Mortgage Learning Center']", logger, "mortgage learning");
        //scroll to the bottom to click on mortgage rate
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll using pixels
        jse.executeScript("scroll(0,2000)");
        Thread.sleep(2000);
        //opens more learning options
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='See more content']", logger, "see more content");
    }//end of mortgage learning center

    @Test(priority = 5)
    public void preApproval(){
        logger.log(LogStatus.INFO, "This test provides user with pre-approval help");
        Actions mouseAction = new Actions(driver);
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        mouseAction.moveToElement(lendTab).perform();
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Buy a Home']", logger, "buy a home");
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Get Started']", logger, "get started");
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Get Started']", logger, "get started again");
        WebElement contactInfo = driver.findElement(By.xpath("//*[text()='Step 2 - How can we reach you?']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",contactInfo);
        //below code adds fills my information in
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='first-name']", "Joy", logger, "first name");
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='last-name']", "Happy", logger, "last name");
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='phone-number']", "3472342233", logger, "Phone Number");
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='email']", "something@yahoo.com", logger, "Email address");
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Submit']", logger, "submit button");
        //below code prints the thank you screen
        String result = ReusableMethods_Logger.captureTextMethod(driver, "//*[@class='copyMod194 container-fluid']", logger, "Get result");
        System.out.println(result);
    }


    @Test(priority = 6)
    public void reviews() throws InterruptedException {
        logger.log(LogStatus.INFO, "This test shows the user reviews for Citibank Lending");
        Actions mouseAction = new Actions(driver);
        WebElement lendTab = driver.findElement(By.xpath("//*[text()='Lending']"));
        mouseAction.moveToElement(lendTab).perform();
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Home Lending']", logger, "home lending");
        WebElement reviews = driver.findElement(By.xpath("//*[text()='Meet Home Captain']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",reviews);
        ReusableMethods_Logger.clickMethod(driver, "//*[@aria-label='rating-text']", logger, "review button");
        Thread.sleep(2000);
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='cta-link btn btn-primary TARGETmodalExternalSiteSpeedbumpZillowReviews#PRIMARY ng-star-inserted']", logger, "continue to review");
        Thread.sleep(3000);
    }


}//end of class
