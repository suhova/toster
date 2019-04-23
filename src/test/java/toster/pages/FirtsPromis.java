package toster.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.logging.Logger;

import static toster.Helper.isElementPresent;

public class FirtsPromis {
    private final static Logger LOGGER = Logger.getLogger(FirtsPromis.class.getName());
    private boolean haveMoney = false;
    WebDriver driver;
//    private final By BALACNCE = By.xpath("//*[@class='send-present_header-balance __with-margin']//span[@data-name='ok-balance']");
//    private WebDriver driver;
//    private String text1="БОГАТЫЙ СОСИСТЕР";
//    private String text2="НИЩИЙ ТОСТЕР";
    private String baseUrl = "https://ok.ru/";

    public FirtsPromis(WebDriver driver) {
        this.driver = driver;
    }

    public void sendPresents() {

        driver.get(baseUrl + "/profile/562478090237");
        driver.findElement(By.xpath(".//div[@class='main-content-header_data mctc-top']")).findElement(By.xpath(".//a[text()='Сделать подарок']")).click();
        PresentPage presentPage = new PresentPage(driver);
        presentPage.choosePresent();
        presentPage.switchToPresentFrame();

        presentPage.addMusic();
        presentPage.switchToPresentFrame();
        presentPage.sendPresent();

        driver.switchTo().defaultContent();
        haveMoney = !isElementPresent(By.xpath(".//*[@class='modal-new_payment-frame']"),driver);

        if (haveMoney) {
            LOGGER.warning("Деньги есть. Отправили подарок с музыкой");
        } else {
            driver.navigate().back();
            presentPage.switchToPresentFrame();
            presentPage.deleteMusic();
            presentPage.sendPresent();
            LOGGER.warning("Денег нет. Отправили подарок без музыки");
        }
    }
}

