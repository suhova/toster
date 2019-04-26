package toster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardWrapper {
    private final WebElement cardFriend;
 //   private final WebDriver driver;
    private final By WRITE=By.xpath(".//*[@class='user-grid-card_cnt']//*[@class='button-pro __sec __small __ic __send-msg mt-x __wide']");


    public CardWrapper(WebElement cardFriend){
        this.cardFriend = cardFriend;
    }
    public String getName(){
        System.out.println( cardFriend.findElement(By.xpath(".//*[@class='user-grid-card_cnt']//*[@class='n-t bold']")).getText());
        return cardFriend.findElement(By.xpath(".//*[@class='user-grid-card_cnt']//*[@class='n-t bold']")).getText();
    }
    public void writeMassage(){
        cardFriend.findElement(WRITE).click();
    }
}
