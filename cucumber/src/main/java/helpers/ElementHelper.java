package helpers;

import features.InitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPage;

import java.time.Duration;

public class ElementHelper extends InitHelper {
    public static WebElement waitForElement(String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static WebElement waitForElement(String locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static WebElement waitForXpath(String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator)));
    }

    public static WebElement waitForXpath(String locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator)));
    }
}
