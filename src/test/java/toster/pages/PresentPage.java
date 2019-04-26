package toster.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static toster.Helper.isElementPresent;

public class PresentPage extends BasePage{
    private final By PRESENT_BLOCK = By.xpath(".//*[@data-block='GiftsFrontContentRBx']");
    private  final By MAKE_PRESENT = By.xpath(".//a[text()='Сделать подарок']");
    private final By FRAME = By.xpath(".//div[@class='main-content-header_data mctc-top']");
    private final By FIRST_PRESET = By.xpath(".//*[@class='ugrid_i soh-s posR floatLeft']");
    private final By FRAME_PRESENT=By.xpath(".//*[@class='modal-new_payment-frame']");
    private final By SEND = By.xpath("//*[@class='js-submit-to-friend button-pro __ic']");

    WebDriver driver;

    @Override
    void check(WebDriver driver) {
        Assert.assertTrue("Нет блока подарков",new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return isElementPresent(PRESENT_BLOCK, d);
            }
        }));
    }

    public PresentPage(WebDriver driver) {
        this.driver = driver;
        check(driver);
    }

    public void choosePresent() {
        //Тут будет ассерт
        if(isElementPresent(FIRST_PRESET,driver)) {
            driver.findElement(FIRST_PRESET).click();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void sendPresent(){
        //Тут будет ассерт
        if(isElementPresent(SEND,driver)) {
            driver.findElement(SEND).click();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void addMusic(){
        //Тут будет ассерт
        if(isElementPresent(By.id("selectMusicTrackLink"),driver)) {
            driver.findElement(By.id("selectMusicTrackLink")).click();
            driver.findElement(By.id("gt_123392913248561")).click();
            driver.findElement(By.id("sendMP")).click();
        } else {
            throw new UnsupportedOperationException();
        }
    }
    public void deleteMusic(){
        //Тут будет ассерт
        if(isElementPresent(By.id("removeMusicTrackLink"),driver)) {
            driver.findElement(By.id("removeMusicTrackLink")).click();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void switchToPresentFrame(){
        //Тут будет ассерт
        if(isElementPresent(FRAME_PRESENT,driver)) {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(FRAME_PRESENT));
        } else {
            throw new UnsupportedOperationException();
        }
    }

}
