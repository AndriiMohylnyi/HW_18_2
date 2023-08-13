import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesReader;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeClass() {
//        WebDriverHolder.getInstance().getDriver();
        driver = WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(PropertiesReader.getInstance().getProperty("app.base.url"));
    }

    public void goToPart(String part) {
        goToUrl(PropertiesReader.getInstance().getProperty("app.base.url") + part);
    }
}
