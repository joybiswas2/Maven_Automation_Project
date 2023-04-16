package Day_12_040223;

import ReusableLibrary.ReusableAnnotations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T2_GetElementsCount extends ReusableAnnotations {
    @Test
    public void getNavListCount() {
        //navigating to usps
        driver.navigate().to("https://www.usps.com");
        //store the elements list in a ArrayList with common property
        WebDriverWait wait = new WebDriverWait(driver, 7);
        ArrayList<WebElement> navList = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]"))));
        System.out.println("Count: " + navList.size());
    }

}
