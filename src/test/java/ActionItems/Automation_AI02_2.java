package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Automation_AI02_2 {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//set up the ArrayList of cars
        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("basketball");
        hobby.add("gym");
        hobby.add("reading");
        hobby.add("running");
//iterate through the list of cars and print out the search number for each car
        for(int i=0; i<hobby.size(); i++){
            //navigate to google home page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            //driver.manage().window().maximize();
            //driver.manage().window().fullscreen(); //for mac

            //wait for 2 seconds
            Thread.sleep(2000);

            //enter hobby to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));

            //click on bing search button
            driver.findElement(By.xpath("//*[@name='form']")).submit();

            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
            Thread.sleep(2000);
            //capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //System.out.println("Search results: " + result);


            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("For " + hobby.get(i) + " the search number is " + arrayResult[1]);

        }//end of loop

        //outside of loop is where you quit/close the driver
        driver.quit();
    }
}
