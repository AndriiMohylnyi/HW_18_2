package stepdefs;

import driver.WebDriverHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertiesReader;

public class LoginSteps {

    WebDriver driver;

    @Given("driver is initialised")
    public void driver_is_initialised() {
        driver = WebDriverHolder.getInstance().getDriver();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.get(PropertiesReader.getInstance().getProperty("app.base.url") + "login");
    }

//    @When("user enters {username} and {password}")
//    public void user_enters_username_and_password(String username, String password) throws InterruptedException {
//        WebElement userNameField = driver.findElement(By.xpath("//*[@id='username']"));
//
//        WebElement userPassField = driver.findElement(By.xpath("//*[@id='password']"));
//
//        userNameField.clear();
//        userNameField.sendKeys(username);
//
//        userPassField.clear();
//        userPassField.sendKeys(password);
//
//        Thread.sleep(2000);
//    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        WebElement userNameField = driver.findElement(By.xpath("//*[@id='username']"));

        WebElement userPassField = driver.findElement(By.xpath("//*[@id='password']"));

        userNameField.clear();
        userNameField.sendKeys("tomsmith");

        userPassField.clear();
        userPassField.sendKeys("SuperSecretPassword!");

        Thread.sleep(2000);
    }


    @And("user clicks on login")
    public void user_clicks_on_login() {
        WebElement buttonLogin = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        buttonLogin.click();
    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        WebElement textLogin = driver.findElement(By.xpath("//*[@id='content']/div/h4"));

        Assert.assertEquals(textLogin.getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }

    @Then("driver quited")
    public void driver_quited() {
        if (driver != null) {
            driver.quit();
        }
    }
}
