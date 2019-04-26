package toster.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static toster.Helper.*;

public class FriendsPage extends BasePage {
    WebDriver driver;
    private By CARD_FRIEND = By.xpath(".//*[@class='user-grid-card']");
    private By LIST_FRIENDS = By.id("hook_Loader_MyFriendsSquareCardsPagingBLoader");
    private By MENU_FRIENDS = By.id("hook_Block_MiddleColumnTopCard_MenuUserFriends");

    public FriendsPage(WebDriver driver) {
        this.driver = driver;
        check(driver);
    }
    @Override
    void check( WebDriver driver) {
        Assert.assertTrue("Нет блока друзей",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementVisible(LIST_FRIENDS, d);
            }
        }));
        Assert.assertTrue("Нет меню друзей в верхней части",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementVisible(MENU_FRIENDS, d);
            }
        }));
    }

    public  List<CardWrapper> getFriends(){
        if(isElementPresent(CARD_FRIEND, driver)){
            List<WebElement> elements = driver.findElements(CARD_FRIEND);
            return CardTransformer.wrap(elements);
        }
        return  Collections.emptyList();
    }

    public CardWrapper friendByName(String name, List<CardWrapper> friends){
        for (CardWrapper friend: friends){
            if(friend.getName().equals(name)) return friend;
        }
        return null;
    }
//    public List<CardWrapper> findAllFriend(){
//        if(isElementPresent(CARD_FRIEND, driver)){
//            List<WebElement> elements = driver.findElements(CARD_FRIEND);
//            return CardTransformer.wrap(elements,driver);
//        }
//        return  Collections.emptyList();
//    }
//
}
