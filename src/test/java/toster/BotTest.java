package toster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import toster.pages.*;
import toster.tests.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class BotTest extends TestBase {
    private String baseUrl;
    private String login;
    private String password;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://vk.com/";
        login = "dasuhovada@yandex.ru";
        password = "mrdodocom0660";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {

        driver.get("https://vk.com/im?peers=136453606&sel=-180868853");
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("login_button")).click();
//
        driver.findElement(By.id("im_editable-180868853")).clear();
    //    driver.findElement(By.id("im_editable-180868853")).sendKeys("1");
     //   driver.findElement(By.xpath(".//*[@class='im-send-btn im-chat-input--send _im_send im-send-btn_send']")).click();
        List<WebElement> mess = driver.findElements(By.xpath(".//*[@class='im-mess--text wall_module _im_log_body']"));

        System.out.println(mess.get(mess.size()-1).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
