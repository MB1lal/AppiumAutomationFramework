package Pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import static driver.DriverBase.getAppiumDriver;

public class AppiumBaseScreen {

    public AppiumBaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    protected void setText(String text, WebElement element) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        moveFocusOnElement(element);
        element.click();
    }

    protected void moveFocusOnElement(WebElement element) {
        new Actions(getAppiumDriver()).moveToElement(element).perform();
    }

}
