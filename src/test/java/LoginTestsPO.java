import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.main.MainPage;
import utils.PropertiesReader;

public class LoginTestsPO extends BaseTestClass {

    String userName = PropertiesReader.getInstance().getProperty("login.tests.username");
    String userPassword = PropertiesReader.getInstance().getProperty("login.tests.password");

//    @BeforeClass
//    public void beforeClass() {
//        goToPart("login");
//    }

    @BeforeMethod
    public void beforeMethod() {
        goToPart("login");
    }

    @Test
    public void unsuccessfulLoginTest() {
        LoginPage loginPage = new LoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");

        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

    @Test
    public void successfulLoginTest() {
        MainPage mainPage = new LoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "Welcome to the Secure Area. When you are done click logout below.");
    }

}
