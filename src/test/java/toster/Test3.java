package toster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import toster.pages.*;
import toster.tests.TestBase;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class Test3 extends TestBase {
    private String baseUrl;
    private String login;
    private String password;
    private String friendName;
    private StringBuffer verificationErrors = new StringBuffer();

    private By frame = By.xpath(".//div[@class='main-content-header_data mctc-top']");
    private  By СДЕЛАТЬ_ПОДАРОК = By.xpath(".//a[text()='Сделать подарок']");
    private  By firstPresent = By.xpath(".//*[@class='ugrid_i soh-s posR floatLeft']");


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        login = "тут был мой логин";
        password = "тут был мой пароль";
        friendName="Станислв Мильке";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {

        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginEnter(login);
        loginPage.passwordEnter(password);
        loginPage.clickEnter();

        driver.get(baseUrl + "/stasmilke");
        driver.findElement(frame).findElement(СДЕЛАТЬ_ПОДАРОК).click();
        driver.findElement(firstPresent).click();

        FirtsPromis firtsPromis = new FirtsPromis(driver);
        firtsPromis.sendPresents();

//        UserMainPage userMainPage = new UserMainPage(driver);
//        userMainPage.openFriendsPage();
//
//        FriendsPage friendsPage = new FriendsPage(driver);
//
//        List<CardWrapper> friends = friendsPage.getFriends();
//        friendsPage.friendByName(friendName, friends).writeMassage();
//        assertEquals(driver.findElement(By.xpath("//*[@class='chat_name_wr']//*[@title]")).getText(), driver.findElement(By.xpath("//*[@class='chats_i h-mod __active']//*[@class='chats_i_h ellip']")).getText());
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
