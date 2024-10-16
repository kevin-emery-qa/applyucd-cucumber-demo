package features;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CucumberSteps {
    static Properties testProperties = new Properties();
    static String appBaseUrl;
    static String baseEmailAddressText;
    static String testPassword;
    static String baseEmailDomain;
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
