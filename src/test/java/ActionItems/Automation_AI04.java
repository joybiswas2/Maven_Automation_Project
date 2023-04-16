package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add maximize for windows
        options.addArguments("start-maximized");
        //add incognito
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //set up an array list for states
        ArrayList<String> state = new ArrayList<>();
        state.add("Las Vegas");
        state.add("Miami");
        state.add("Manhattan");

        //loop for states
        for(int i = 0; i < state.size(); i ++){
            //navigates to hotel.com
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(1500);

            //driver for clicking on going to
            try{
                WebElement location = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                location.click();
            }catch(Exception e){
                System.out.println("Unable to click on search" + e);
            }//end of first exception statement

            Thread.sleep(1500);
            //driver for clicking on search field
            try{
                WebElement searchField = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                searchField.click();
                //searchField.clear();
                searchField.sendKeys(state.get(i));
                Thread.sleep(1500);
                //this driver clicks on the first suggestion
                driver.findElement(By.xpath("//*[@data-index='0']")).click();
                Thread.sleep(1500);
            }catch (Exception e) {
                System.out.println("Unable to click on search field" + e);
            }//end of second exception statement

            Thread.sleep(1500);
            //driver for clicking on travelers
            try{
                WebElement people = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));
                people.click();
            }catch (Exception e){
                System.out.println("Unable to click on number of travelers" + e);
            }//end of third exception statement
            Thread.sleep(1500);

            //arraylist for adults
            //ArrayList<Integer> adults = new ArrayList<>();
            //adults.add(2);

            try {
                //arraylist for adults
                ArrayList<Integer> adults = new ArrayList<>();
                adults.add(2);
                //web element for person button
                WebElement button = driver.findElement(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']"));
                button.click();
                Thread.sleep(1000);
                //loop to get number of adults
                for (int j = 0; j < adults.get(i); j++) {
                    driver.findElements(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']"));
                }
            }catch (Exception e){
                System.out.println("Unable to click on number of adults");
            }

            //ArrayList<Integer> childAge = new ArrayList<>();
            try {
                //Arraylist for child age
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
                WebElement childAge = driver.findElement(By.xpath("//*[@name='child-traveler_selector_children_age_selector-0-0']"));
                Select dropDown = new Select(childAge);
                dropDown.selectByVisibleText("1");
            }catch (Exception e){
                System.out.println("Unable to clock on child dropdown");
            }

            Thread.sleep(1500);

            //this is to search
            try{
                driver.findElement(By.xpath("//*[@id='search_button']")).click();
            }catch (Exception e){
                System.out.println("Unable to search");
            }
            Thread.sleep(1500);

            ArrayList<WebElement> locations = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));
            if (i == 0) {
                locations.get(1).click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                System.out.println(hotelName);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println(price);
                WebElement reserveButton = driver.findElements(By.xpath("//*[text()='Reserve']")).get(1);
                reserveButton.click();
                //driver.findElement(By.xpath("//*[text()='Pay now']"));
                Thread.sleep(2000);
                String dates = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                System.out.println(dates);
                //driver.close();
            }
            if (i == 1) {
                locations.get(3).click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                System.out.println(hotelName);
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println(price);
                //driver.close();
            }
            if (i == 2) {
                locations.get(2).click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                System.out.println(hotelName);
                Thread.sleep(1500);
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println(price);
            }//end of conditional statements
            Thread.sleep(1500);

            //call the window handles in array list and switch to the new tab
            //ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab by index of 1
            //driver.switchTo().window(tabs.get(1));
            //Thread.sleep(1500);


        }//end of for loop
    //driver.quit();
    }//end of main
}//end of class