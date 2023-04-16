package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI03 {
    public static void main(String[] args) throws InterruptedException {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add maximize for windows
        options.addArguments("start-maximized");
        //add igcognito
        options.addArguments("incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        //declare array
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10462");
        zipCode.add("10472");
        zipCode.add("10452");
        //loop to repeat zipcodes
        for (int i = 0; i < zipCode.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='In-Person']")).click();
            WebElement searchButton = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchButton.clear();
            searchButton.sendKeys(zipCode.get(i));
            //for submit button
            WebElement submitButton = driver.findElement(By.xpath("//*[@id='location-search-cta']"));
            submitButton.submit();
            Thread.sleep(2000);
            ArrayList<WebElement> locations = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")));
            if (i == 0) {
                locations.get(1).click();
            }
            if (i == 1) {
                locations.get(2).click();
            }
            if (i == 2) {
                locations.get(0).click();
            }//end of conditional statements
            Thread.sleep(2000);

            String address = driver.findElement(By.xpath("//*[contains(@class,'infoContainer')]")).getText();
            System.out.println(address);
            Thread.sleep(2000);
            //scroll java function
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement scroll = driver.findElement(By.xpath("//*[contains(text(),'Upcoming In-Person')]"));
            jse.executeScript("arguments[0].scrollIntoView(true)", scroll);
            Thread.sleep(2000);
            //this will print out the schedule
            String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
            System.out.println(schedule);
        }//end of loop
        driver.quit(); //driver quits

    }

}//end of main
