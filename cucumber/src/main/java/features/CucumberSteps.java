package features;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CucumberSteps {
    static Properties testProperties = new Properties();
    static String appBaseUrl;
    public static void initializeProperties() {
        try {
            FileReader reader = new FileReader("applyuctest.properties");
            testProperties.load(reader);
            appBaseUrl = testProperties.getProperty("appBaseUrl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
