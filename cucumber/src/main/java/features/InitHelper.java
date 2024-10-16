package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitHelper {
    public static WebDriver driver;
    static Properties testProperties = new Properties();
    static String appBaseUrl;
    static String baseEmailAddressText;
    static String testPassword;
    static String baseEmailDomain;

    public static void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    public static void initializeProperties() {
        try {
            FileReader reader = new FileReader("applyuctest.properties");
            testProperties.load(reader);
            appBaseUrl = testProperties.getProperty("appBaseUrl");
            baseEmailAddressText = testProperties.getProperty("baseEmailAddressText");
            baseEmailDomain = testProperties.getProperty("baseEmailDomain");
            testPassword = testProperties.getProperty("testPassword");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
