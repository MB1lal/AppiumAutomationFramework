package steps;

import Pages.TestAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class IOSAppSteps extends BaseSteps {

    @Steps
    TestAppPage testAppPage;

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
}
