package steps;

import Pages.TestAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class iOSAppSteps extends BaseSteps {

    @Steps
     TestAppPage testAppPage;

    @Given("User inputs {int} as {string} number")
    public void verifyAppIsLaunched(int number, String numberField) {
        logger.info("App launched");
        switch (numberField.toLowerCase()) {
            case "first" -> testAppPage.enterFirstNumber(number);
            case "second" -> testAppPage.enterSecondNumber(number);
        }
    }

    @When("User presses the sum button")
    public void pressSumButton() {
        testAppPage.pressSumButton();
    }

    @Then("The sum should be {int}")
    public void verifySumIsCorrect(int result) {
        assertThat(testAppPage.getSumOfNumbers())
                .isEqualTo(String.valueOf(result));
    }
}
