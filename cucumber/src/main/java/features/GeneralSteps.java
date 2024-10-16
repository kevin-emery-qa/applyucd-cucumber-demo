package features;

import io.cucumber.java.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LandingPage;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GeneralSteps {
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("https://applyucd.ucop.edu/");
    }

    @Given("The page has loaded and I see the button to apply")
    public void iSeeTheButtonToApply() {
        WebElement createAccountElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountButton));
        Assert.assertTrue(createAccountElement.isEnabled());
        Assert.assertTrue(createAccountElement.isDisplayed());
    }

    @AfterAll
    public static void afterAll() {
        driver.close();
    }
}
