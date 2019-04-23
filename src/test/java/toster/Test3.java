package toster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import toster.pages.*;
import toster.tests.TestBase;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class Test3 extends TestBase {
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
    public void testCase() throws Exception {

        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginEnter(login);
        loginPage.passwordEnter(password);
        loginPage.clickEnter();


//        driver.findElement(By.id("present-text")).sendKeys(text1);
//        driver.get(baseUrl + "/gifts/sent");
//
//
//        Assert.assertNotEquals(text1, driver.findElement(By.xpath("//*[@class='gifts-column-grid_col js-gcg-first-col']//*[@class='gift-card_msg_cnt']")).getText());
//
//
//        driver.get(baseUrl + "/gifts/sent");
//        Assert.assertEquals(text2, driver.findElement(By.xpath("//*[@class='gifts-column-grid_col js-gcg-first-col']//*[@class='gift-card_msg_cnt']")).getText());


        FirtsPromis firtsPromis = new FirtsPromis(driver);
        firtsPromis.sendPresents();
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
