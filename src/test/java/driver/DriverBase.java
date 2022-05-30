package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverBase {
    private static AppiumDriver driver;

    public static void initializeDriver(URL appiumURL, DesiredCapabilities capabilities) {
       initIOSDriver(appiumURL, capabilities);
    }
    public static AppiumDriver getAppiumDriver() {
        return driver;
    }

    private static void initIOSDriver(URL appiumURL, DesiredCapabilities capabilities) {
        driver = new IOSDriver(appiumURL, capabilities);
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
