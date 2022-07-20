package steps;

import Pages.HerokuPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class HerokuLogin extends BaseSteps{

    @Steps
    HerokuPages herokuPages;

    @Given("User navigates to heroku")
    public void user_navigates_to_heroku() {
        herokuPages.navigateToHerokuLogin();
    }
    @And("User enters username and password")
    public void user_enters_username_and_password() {
       herokuPages.enterUsername("tomsmith");
       herokuPages.enterPassword("SuperSecretPassword!");
    }
    @When("User presses login button")
    public void user_presses_login_button() {
        herokuPages.clickLogin();
    }
    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        assertTrue(herokuPages.userIsLoggedIn());
    }

    @And("User logs out")
    public void logoutUser() {
        herokuPages.logout();
    }


}
