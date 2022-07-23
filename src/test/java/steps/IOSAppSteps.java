package steps;

import pages.GestureAppPage;
import pages.TestAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class IOSAppSteps extends BaseSteps {

    @Steps
    TestAppPage testAppPage;

    @Steps
    GestureAppPage gestureAppPage;

    @Given("User inputs {int} as {string} number")
    public void verifyAppIsLaunched(int number, String numberField) {
        switch (numberField.toLowerCase()) {
            case "first": testAppPage.enterFirstNumber(number);
            case "second": testAppPage.enterSecondNumber(number);
        }
    }

    @When("User presses the sum button")
    public void pressSumButton() {
        testAppPage.pressSumButton();
    }

    @Then("The sum should be {int}")
    public void verifySumIsCorrect(int result) {
        assertEquals(testAppPage.getSumOfNumbers(),String.valueOf(result));
    }

    @Given("User clicks on show alert button")
    public void clickOnAlertButton() {
        testAppPage.clickOnAlertButton();
    }

    @Then("The alert should be displayed")
    public void assertingAlertPresence() {
        assertThat(testAppPage.alertIsDisplayed()).isTrue();
    }

    @When("User clicks on okay")
    public void clickOkayOnAlert() {
        testAppPage.clickOkayButton();
    }

    @Then("The popup is closed")
    public void popupIsClosed() {
        assertThat(testAppPage.alertIsDisplayed()).isFalse();
    }

    @When("User slides the slider to {}")
    public void slideToLeft(String slidingDirection) {
        testAppPage.slideTo(slidingDirection);
    }

    @Then("The slider percentage {} {}")
    public void assertSliderPercentage(String comparison, String expectedSliderPercentage) {
        if(comparison.equals("<")) {
            assertThat(testAppPage.getSliderPercent()).isLessThan(expectedSliderPercentage);
        }
        if(comparison.equals(">")) {
            assertThat(testAppPage.getSliderPercent()).isGreaterThan(expectedSliderPercentage);
        }
    }

    @Given("User clicks on test gesture")
    public void clickOnTestGesture() {
        testAppPage.clickTestGesture();
    }

    @When("User pans the screen to the {}")
    public void panTheScreen(String direction) {
        switch (direction.toLowerCase()) {
            case "right":
                gestureAppPage.panTheScreenTo(direction);
                break;
            case "left":

                break;
        }
    }

    @Then("Map now displays {}")
    public void assertingScreenIsMoved(String expectedLocationName) throws InterruptedException {
        Thread.sleep(4000);
        assertThat(gestureAppPage.OnScreenLocationName()).contains(expectedLocationName);
    }
}
