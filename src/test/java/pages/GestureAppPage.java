package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import static driver.DriverBase.getAppiumDriver;

public class GestureAppPage extends AppiumBaseScreen {

    @AndroidFindBy(xpath ="//*/XCUIElementTypeMap")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeMap")
    private WebElement mapElement;



    @Step
    public void panTheScreenTo(String direction) {
        swipeOnElement(mapElement, direction);
    }

    @Step
    public String OnScreenLocationName() {
        return getAppiumDriver().getPageSource();
    }
}
