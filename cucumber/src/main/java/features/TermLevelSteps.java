package features;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchSessionException;

import io.cucumber.java.BeforeAll;
import pages.TermLevelPage;

import static org.junit.Assert.assertTrue;

public class TermLevelSteps extends InitHelper {
    @BeforeAll
    public static void beforeAll() {
        initializeDriver();
        initializeProperties();
        driver.navigate().to(appBaseUrl);
    }

    @When("I select the latest Fall semester")
    public void iSelectTheLatestFallSemester() {
        TermLevelPage.selectLatestFallSemester();
    }

    @And("I select the {string} application level")
    public void iSelectTheTransferLevel(String transferLevel) {
        TermLevelPage.selectButtonByText(transferLevel);
        assertTrue(true);
    }

    @AfterAll
    public static void afterAll() {
        try {
            driver.close();
        } catch (NoSuchSessionException ignored) { }
    }
}
