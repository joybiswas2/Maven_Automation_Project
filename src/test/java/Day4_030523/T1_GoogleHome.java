package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleHome {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

        //navigates to google home page
        driver.navigate().to("https://www.google.com");

        //maximize the browser
        driver.manage().window().maximize();

        //wait 2 seconds
        Thread.sleep(2000);


        //enter keyword bmw to search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

        //click on google
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //capture the search results using .getText()
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Search results: " + result);

        //print out the number result
        String[] arrayResult = result.split(" ");
        System.out.println("Search result: " + arrayResult[1]);

        //simply close/quit the driver/browser
        driver.close();

    }
}
