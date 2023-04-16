package Day_7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectStatementDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");
        //add igcognito
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);
        //store the start month locator as a WebElement
        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        Select startMonthDropdown = new Select(strMonth);
        //select by visible text
        startMonthDropdown.selectByVisibleText("Apr");
        //select by value
        //startMonthDropdown.selectByValue("4")
        //select by index
        //startMonthDropdown.selectByIndex(3);

    }//end of main
}//end of class