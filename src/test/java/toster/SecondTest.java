package toster;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import toster.pages.CardWrapper;
import toster.pages.FriendsPage;
import toster.pages.LoginPage;
import toster.pages.UserMainPage;
import toster.tests.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SecondTest extends TestBase {
    private String baseUrl;
    private String login;
    private String password;
    private String friendName;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        login = "+79110089701";
        password = "mrdodocom0660";
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

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.openFriendsPage();

        FriendsPage friendsPage = new FriendsPage(driver);

        List<CardWrapper> friends = friendsPage.getFriends();
        friendsPage.friendByName(friendName, friends).writeMassage();
        assertEquals(driver.findElement(By.xpath("//*[@class='chat_name_wr']//*[@title]")).getText(), driver.findElement(By.xpath("//*[@class='chats_i h-mod __active']//*[@class='chats_i_h ellip']")).getText());
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

