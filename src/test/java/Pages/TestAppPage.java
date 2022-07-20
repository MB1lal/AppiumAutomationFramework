package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TestAppPage extends AppiumBaseScreen {
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

    @AndroidFindBy(id ="show alert")
    @iOSXCUITFindBy(accessibility = "show alert")
    private WebElement btnShowAlert;

    @AndroidFindBy(id ="Cool title")
    @iOSXCUITFindBy(accessibility = "Cool title")
    private WebElement lblAlertTitle;

    @AndroidFindBy(id ="OK")
    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement btnAlertOk;

    @AndroidFindBy(id ="Cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    private WebElement btnAlertCancel;

    @Step("Enter 1st number")
    public void enterFirstNumber(int number) {
        txtFirstNumberField.clear();
        txtFirstNumberField.sendKeys(String.valueOf(number));
    }
    @Step("Enter 2nd number")
    public void enterSecondNumber(int number) {
        txtSecondNumberField.clear();
        txtSecondNumberField.sendKeys(String.valueOf(number));
    }
    @Step("Press sum button")
    public void pressSumButton() {
        btnComputeSum.click();
    }

    @Step("Return sum of numbers")
    public String getSumOfNumbers() {
        return lblSumResults.getText();
    }

    @Step
    public void clickOnAlertButton() {
        btnShowAlert.click();
    }

    @Step
    public boolean alertIsDisplayed() {
        try{
            return lblAlertTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step
    public void clickOkayButton() {
        btnAlertOk.click();
    }

}
