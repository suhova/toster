package toster.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static toster.Helper.*;

public class UserMainPage extends BasePage {
    WebDriver driver;
    private final By NAVIGATION_BLOCK = By.id("hook_Block_Navigation");
    private final By NAVIGATION_TOOLBAR = By.xpath("//*[@class='toolbar_c']");
    private final By MAIN_BLOCK = By.id("hook_Block_UserMainFullMRB");


    public UserMainPage(WebDriver driver) {
        this.driver = driver;
        check(driver);
    }
    @Override
    void check( WebDriver driver) {
        Assert.assertTrue("Нет блока навигациии",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementPresent(NAVIGATION_BLOCK, d);
            }
        }));
        Assert.assertTrue("Нет строки навигациии",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementVisible(NAVIGATION_TOOLBAR, d);
            }
        }));
        Assert.assertTrue("Нет главного блока",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementVisible(MAIN_BLOCK, d);
            }
        }));
    }

    public void openFriendsPage(){
        if(isElementPresent(By.xpath("//*[@href='/profile/578527183595/friends' and @class='nav-side_i  __with-ic']"),driver)) {
            driver.findElement(By.xpath("//*[@href='/profile/578527183595/friends' and @class='nav-side_i  __with-ic']")).click();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
