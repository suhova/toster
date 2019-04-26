package toster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.logging.Logger;

import static toster.Helper.isElementPresent;

public class PresentPromis {
    private final static Logger LOGGER = Logger.getLogger(PresentPromis.class.getName());
    WebDriver driver;
    private String baseUrl = "https://ok.ru/";

    private By btMakePresent = By.xpath(".//a[text()='Сделать подарок']");
    private By toolBar = By.xpath(".//div[@class='main-content-header_data mctc-top']");

    private int money;
    private int countMusic;

    public PresentPromis(WebDriver driver) {
        this.driver = driver;
    }

    public void sendPresents(String friendUrl) {
        driver.get(friendUrl);

        driver.findElement(toolBar).findElement(btMakePresent).click();
        PresentPage presentPage = new PresentPage(driver);
        presentPage.choosePresent();
        presentPage.switchToPresentFrame();

        //Добавили музыку
        presentPage.addMusic();
        countMusic++;
        presentPage.switchToPresentFrame();

        if (haveMoney()) {
            presentPage.sendPresent();
            LOGGER.warning("Отправили подарок с " + countMusic + " треками");
        } else {
            //Всё круто, без денег платный подарок не отправить
            for (int i = 0; i < (countMusic - money); i++) {
                presentPage.deleteMusic();
                countMusic--;
            }
            presentPage.sendPresent();
            LOGGER.warning("Денег не хватило. Отправили подарок с " + countMusic + " треками");
        }
        driver.switchTo().defaultContent();
    }

    private boolean haveMoney() {

        String s = driver.findElement(By.xpath(".//span[@data-name='ok-balance']")).getText();


        money = Integer.parseInt(s);
        if(countMusic <= money){
            return true;
        }
        return false;
    }
}

