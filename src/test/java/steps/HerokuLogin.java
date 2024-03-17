package steps;

import net.serenitybdd.annotations.Steps;
import pages.HerokuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class HerokuLogin extends BaseSteps{

    @Steps
    HerokuPage herokuPage;

    @Given("User navigates to heroku")
    public void user_navigates_to_heroku() {
        herokuPage.navigateToHerokuLogin();
    }
    @And("User enters username and password")
    public void user_enters_username_and_password() {
       herokuPage.enterUsername("tomsmith");
       herokuPage.enterPassword("SuperSecretPassword!");
    }
    @When("User presses login button")
    public void user_presses_login_button() {
        herokuPage.clickLogin();
    }
    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        assertThat(herokuPage.userIsLoggedIn()).isTrue();
    }

    @And("User logs out")
    public void logoutUser() {
        herokuPage.logout();
    }

    @And("User is logged out")
    public void user_Should_be_logged_out() {
        assertThat(herokuPage.userIsLoggedOut()).isTrue();
    }


}
