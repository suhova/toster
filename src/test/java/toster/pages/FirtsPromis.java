package toster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class FirtsPromis {
    private final static Logger LOGGER = Logger.getLogger(FirtsPromis.class.getName());
    private boolean haveMoney = false;
    private WebDriver driver;

    public FirtsPromis(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void sendPresents() {

        int money = Integer.parseInt(driver.findElement(By.xpath(".//*[@class='send-present_header-balance __with-margin']//span [@data-name='ok-balance']")).getText());

        driver.findElement(By.xpath(".//*[@id='selectMusicTrackLink']")).click();
        int countMusic;



//        driver.findElement(By.xpath(".//*[@class='track_cnt']")).click();
//        driver.findElement(By.xpath(".//*[@class='modal_buttons_yes form-actions_yes button-pro']")).click();
        driver.findElement(By.xpath(".//*[contains(text(),'Подарить за ')]")).click();


        if (haveMoney) {
            LOGGER.warning("Отправили подарок");


        } else {
            LOGGER.warning("Нет денег - поплняем счет");
        }


    }


}

