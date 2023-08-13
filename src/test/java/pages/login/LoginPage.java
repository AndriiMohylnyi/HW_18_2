package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.main.MainPage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;

    // Два методи вище майже однаковий код, тому зробимо третій метод
    private LoginPage enterValueToWebElement(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
        return this;
    }

    // Змінемо 2 попередніх методи
    private LoginPage setUserName(String userName) {
        return enterValueToWebElement(userInput, userName);
    }

    private LoginPage setUserPassword(String userPassword) {
        return enterValueToWebElement(passwordInput, userPassword);
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public LoginPage() {
        super();
    }

    public LoginPage unsuccessfulLogin(String userName, String passwordName) {
        setUserName(userName)
                .setUserPassword(passwordName)
                .clickLoginButton();
        return new LoginPage();
    }

    public MainPage login(String userName, String passwordName) {
        setUserName(userName)
                .setUserPassword(passwordName)
                .clickLoginButton();
        return new MainPage();
    }

    @FindBy(id = "flash")
    private WebElement errorMessage;

    public String getErrorMessageText() {
        return errorMessage.getText();
    }


}
