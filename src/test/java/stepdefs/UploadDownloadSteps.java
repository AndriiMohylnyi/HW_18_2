package stepdefs;

import driver.WebDriverHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.MyFilesUtils;
import utils.PropertiesReader;

import java.io.File;
import java.io.IOException;

public class UploadDownloadSteps {
    WebDriver driver;
    File file;

    {
        try {
            file = MyFilesUtils.generateLoremFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Given("drivers are initialised")
    public void driver_is_initialised() {
        driver = WebDriverHolder.getInstance().getDriver();
    }

    @And("go to upload")
    public void go_to_upload() {
        driver.get(PropertiesReader.getInstance().getProperty("app.base.url") + "upload");
    }

    @When("find file upload")
    public void find_file_upload() {
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());

    }

    @And("click file submit")
    public void click_file_submit() {
        driver.findElement(By.id("file-submit")).click();
    }

    @Then("find uploaded files")
    public void find_uploaded_files() {
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());
    }

    @And("go to download")
    public void go_to_download() {
        driver.get(PropertiesReader.getInstance().getProperty("app.base.url") + "download");
    }

    @Then("find downloaded files")
    public void find_downloaded_files() {
        Assert.assertTrue(driver.findElement(By.linkText(file.getName())).isDisplayed());
    }

    @And("drivers quited")
    public void drivers_quited() {
        if (driver != null) {
            driver.quit();
        }
    }
}
