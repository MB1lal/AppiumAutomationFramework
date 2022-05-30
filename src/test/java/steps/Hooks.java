package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static driver.DriverBase.closeDriver;
import static driver.DriverBase.initializeDriver;

import static utils.SharedStateConstants.EXCEL_DATA;

public class Hooks extends BaseSteps{

    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AppiumDriver driver;

    @Before(value = "@appium", order = 0)
    public void startAppiumService() {
        // From Appium 2.0 Beta
//        AppiumDriverLocalService service;
//        service = new AppiumServiceBuilder()
//                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .build();
//        service.start();

    }
    @Before(value = "@appium", order = 1)
    public void setupAppium(Scenario scenario) throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 mini");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");

        if(scenario.getSourceTagNames().contains("@appiumApp")) {
//        capabilities.setCapability(MobileCapabilityType.UDID,"41E1C392-6EED-488B-9B44-72ED0373845A");

//         MobileCapabilityType.APP is set to the IOS app bundle file path that was created in Step 1. Replace it with your app bundle file path.
            capabilities
                    .setCapability(MobileCapabilityType.APP,
                            "/Users/bilal/Documents/ios-test-app/build/Release-iphonesimulator/TestApp-iphonesimulator.app");
        }
        else if(scenario.getSourceTagNames().contains("@appiumBrowser")) {
            capabilities.setCapability("safari:useSimulator", true);
            capabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, "Safari");
        }

        initializeDriver(url,capabilities);
    }

    @After(value = "@appium")
    public void tearDownAppium() {
        closeDriver();
    }

    @Before
    public void bootstrap(Scenario scenario) {
        if(scenario.getSourceTagNames().contains("@excelData")) {
            utils.ExcelReader excelReader = utils.ExcelReader.getInstance();
            try
            {
                Serenity.setSessionVariable(EXCEL_DATA).to(excelReader.readExcel("Input"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
