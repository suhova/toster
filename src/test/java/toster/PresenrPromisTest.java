package toster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import toster.pages.*;
import toster.tests.TestBase;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class PresenrPromisTest extends TestBase {
    private String baseUrl;
    private String login;
    private String password;
    private String text1;
    private String text2;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        login = "логин";
        password = "пароль";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void present() throws Exception {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);

        UserMainPage myPage = loginPage.loginEnter(login).passwordEnter(password).clickEnter();

        String frendUrl = baseUrl + "/profile/562478090237";

        PresentPromis firtsPromis = new PresentPromis(driver);
        firtsPromis.sendPresents(frendUrl);

//        driver.get(baseUrl + "gifts/sent");
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
