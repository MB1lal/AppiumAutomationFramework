package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static driver.DriverBase.getAppiumDriver;

public class TestAppPage {

    TestAppPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    @AndroidFindBy(id ="IntegerA")
    @iOSXCUITFindBy(accessibility = "IntegerA")
    private WebElement txtFirstNumberField;

    @AndroidFindBy(id ="IntegerB")
    @iOSXCUITFindBy(accessibility = "IntegerB")
    private WebElement txtSecondNumberField;

    @AndroidFindBy(id ="ComputeSumButton")
    @iOSXCUITFindBy(accessibility = "ComputeSumButton")
    private WebElement btnComputeSum;

    @AndroidFindBy(id ="Answer")
    @iOSXCUITFindBy(accessibility = "Answer")
    private WebElement lblSumResults;

    @Step("Enter numbers into fields")
    public void enterFirstNumber(int number) {
        txtFirstNumberField.click();
        txtFirstNumberField.sendKeys(String.valueOf(number));
    }

    public void enterSecondNumber(int number) {
        txtFirstNumberField.sendKeys(String.valueOf(number));
    }

    public void pressSumButton() {
        btnComputeSum.click();
    }

    public String getSumOfNumbers() {
        return lblSumResults.getText();
    }

}
