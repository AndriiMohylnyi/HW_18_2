package pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MainPage extends BasePage {

    public MainPage() {
        super();
    }

    @FindBy(xpath = "//*[@id='content']/div/h4")
    private WebElement successfulMessage;

    public String getSuccessMessageText() {
        return successfulMessage.getText();
    }

}
