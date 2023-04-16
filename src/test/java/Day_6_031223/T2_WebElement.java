package Day_6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElement {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");
        //add igcognito
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo home page
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

        //clear auto populated data from purchase price
        pPrice.clear();
        //enter new purchase price
        pPrice.sendKeys("250000");
        //click on calculate
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        //capture the only payment and total 360
        ArrayList<WebElement> pPriceList = new ArrayList<>(driver.findElements(By.xpath("//*[@name='ma']")));

        String result = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
        System.out.println("Monthly Payment: " + result);

        String result2 = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
        System.out.println("Monthly Payment: " + result2);



    }
}
