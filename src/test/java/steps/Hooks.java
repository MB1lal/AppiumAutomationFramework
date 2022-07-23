package steps;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.safari.options.SafariOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;
import java.net.URL;

import static driver.DriverBase.closeDriver;
import static driver.DriverBase.initializeDriver;

public class Hooks extends BaseSteps{

    public static URL url;
    private static AppiumDriverLocalService service;

    @BeforeAll
    public static void startAppiumService() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Before(value = "@appium", order = 1)
    public void setupAppium(Scenario scenario) throws MalformedURLException {
        final String URL_STRING = service.getUrl().toString();
        url = new URL(URL_STRING);

        if(scenario.getSourceTagNames().contains("@appiumApp")) {
            XCUITestOptions capabilities = new XCUITestOptions()
                    .setDeviceName("iPhone 13 mini")
                    .setAutomationName("XCUITest")
                    .setPlatformVersion("15.5")
                    .setPlatformName("iOS")
                    .setApp("/Users/bilal/Documents/ios-test-app/build/Release-iphonesimulator/TestApp-iphonesimulator.app");

            initializeDriver(url,capabilities);
        }
        else if(scenario.getSourceTagNames().contains("@appiumBrowser")) {
            SafariOptions capabilities = new SafariOptions()
                    .setPlatformVersion("15.5")
                    .setAutomationName("Safari")
                    .setSafariDeviceName("iPhone 13 mini")
                    .setSafariUseSimulator(true)
                    .setPlatformName("iOS");

            initializeDriver(url, capabilities);
        }
    }

    @AfterAll
    public static void tearDownAppium() {
        closeDriver();
        service.stop();
    }

    @Before
    public void bootstrap(Scenario scenario) {

    }
}
