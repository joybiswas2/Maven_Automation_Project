package Day2_022623;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='Search Amazon']")).sendKeys("BMW");
        driver.findElement(By.xpath("//*[@clas='btnK']")).submit();
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String[] arrayResult = result.split(" ");
        System.out.println("Search result: " + arrayResult[1]);
        driver.close();
    }
}
