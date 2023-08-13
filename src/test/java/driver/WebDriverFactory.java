package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver initDriver(DriverManagerType webDriverType) {
        WebDriver driver = WebDriverManager.getInstance(webDriverType).getWebDriver();
//        switch (webDriverType) {
//            case CHROME:
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case EDGE:
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                break;
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initDriver() {
        DriverManagerType webDriverType = null;
        try {
            webDriverType = DriverManagerType.valueOf(System.getProperty("webDriverType", "chrome").toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("This driver is not supported. \nPlease choose: chrome, edge, firefox");
            System.exit(-1); // Щоб не йшло виконання далі
        }
        return initDriver(webDriverType);
    }
}
