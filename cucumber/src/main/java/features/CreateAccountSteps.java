package features;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import pages.LandingPage;
import pages.TermLevelPage;
import helpers.StringHelper;
import helpers.ElementHelper;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class CreateAccountSteps extends InitHelper {
    @BeforeAll
    public static void beforeAll() {
        initializeDriver();
        initializeProperties();
        driver.navigate().to(appBaseUrl);
    }

    @Given("The login page has loaded and I see the button to apply")
    public void iSeeTheButtonToApply() {
        WebElement createAccountElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountButton));
        assertTrue(createAccountElement.isEnabled());
        assertTrue(createAccountElement.isDisplayed());
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
        WebElement termsOfUseCheckbox = driver.findElement(By.cssSelector(LandingPage.Locators.termsOfUseCheckbox));
        assertTrue(emailElement.isEnabled());
        assertTrue(passwordElement.isEnabled());
        assertTrue(confirmPasswordElement.isEnabled());
        assertTrue(createAccountSubmitButton.isEnabled());
        assertTrue(termsOfUseCheckbox.isEnabled());
        Assert.assertFalse(termsOfUseCheckbox.isSelected());
    }

    @When("I submit the form to create a new account")
    public void iSubmitTheFormToCreateANewAccount() {
        WebElement emailElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountEmail));
        WebElement confirmEmailElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountConfirmEmail));
        WebElement passwordElement = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountPassword));
        WebElement createAccountSubmitButton = driver.findElement(By.cssSelector(LandingPage.Locators.createAccountSubmitButton));
        WebElement termsOfUseCheckbox = ElementHelper.waitForElement(LandingPage.Locators.termsOfUseCheckbox);

        // generates a one-time email address like testaccount+202401010930@gmail.com which will go to testaccount@gmail.com
        String testUserEmail = baseEmailAddressText + "+" + StringHelper.dateTimeString() + baseEmailDomain;

        emailElement.sendKeys(testUserEmail);
        confirmEmailElement.sendKeys(testUserEmail);
        passwordElement.sendKeys(testPassword);
        Assert.assertFalse(termsOfUseCheckbox.isSelected());

        termsOfUseCheckbox.click();
        assertTrue(termsOfUseCheckbox.isSelected());

        createAccountSubmitButton.click();
    }

    @Then("I am on the term level selection page")
    public void iAmOnTheTermLevelSelectionPage() {
        WebElement termSelectionPageElement = ElementHelper.waitForXpath(TermLevelPage.Locators.termSelectionPageLabel, 5);
        assertTrue(termSelectionPageElement.isDisplayed());
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/my-application/term-level"));
    }

    @Given("I am applying with a new account and I have reached the term selection page")
    public void iAmApplyingWithANewAccountAndIHaveReachedTheTermSelectionPage() {
        iSeeTheButtonToApply();
        iClickTheButtonToCreateAnAccount();
        iSeeTheFormToCreateANewAccount();
        iSubmitTheFormToCreateANewAccount();
        iAmOnTheTermLevelSelectionPage();
    }

    @AfterAll
    public static void afterAll() {
        try {
            driver.close();
        } catch (NoSuchSessionException ignored) { }
    }
}
