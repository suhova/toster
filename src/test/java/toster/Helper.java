package toster;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Helper {

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
