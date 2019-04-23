package toster;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class Helper {

    public static boolean isPresentElement(By by, WebDriver driver){
        return driver.findElements(by).size() > 0;
//        (new WebDriverWait(driver,10))
      //         .until(ExpectedConditions.visibilityOfElementLocated(by));
      //  ExpectedConditions.elementIfVisible(driver.findElement(by));
      //  WebElement element = driver.findElement(by);

       // return driver.findElement(by).isDisplayed() ? true : false;
    }
    public static boolean isElementVisible(By by, WebDriver driver){
        try {
            ExpectedConditions.visibilityOfElementLocated(by);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public static boolean isElementPresent(By by, WebDriver driver)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }


}
