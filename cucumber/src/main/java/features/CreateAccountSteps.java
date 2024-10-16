package features;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LandingPage;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccountSteps extends CucumberSteps {
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        initializeProperties();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to(appBaseUrl);
    }

    @Given("The login page has loaded and I see the button to apply")
    public void iSeeTheButtonToApply() {
        WebElement createAccountElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountButton));
        Assert.assertTrue(createAccountElement.isEnabled());
        Assert.assertTrue(createAccountElement.isDisplayed());
    }

    @When("I click the button to create an account")
    public void iClickTheButtonToCreateAnAccount() {
        WebElement createAccountElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountButton));
        createAccountElement.click();
    }

    @Then("I see the form to create a new account")
    public void iSeeTheFormToCreateANewAccount() {
        WebElement emailElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountEmail));
        WebElement passwordElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountConfirmEmail));
        WebElement confirmPasswordElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountPassword));
        WebElement createAccountSubmitButton = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountSubmitButton));
        Assert.assertTrue(emailElement.isEnabled());
        Assert.assertTrue(passwordElement.isEnabled());
        Assert.assertTrue(confirmPasswordElement.isEnabled());
        Assert.assertTrue(createAccountSubmitButton.isEnabled());
    }

    @When("I submit the form to create a new account")
    public void iSubmitTheFormToCreateANewAccount() {
        WebElement emailElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountEmail));
        WebElement passwordElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountConfirmEmail));
        WebElement confirmPasswordElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountPassword));
        WebElement createAccountSubmitButton = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountSubmitButton));
        emailElement.sendKeys("");
    }

    @AfterAll
    public static void afterAll() {
        driver.close();
    }
}
