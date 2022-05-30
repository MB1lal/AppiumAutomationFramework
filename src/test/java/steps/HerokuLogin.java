package steps;

import Pages.HerokuPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class HerokuLogin extends BaseSteps{

    HerokuPages herokuPages = new HerokuPages();

    @Given("User navigates to heroku")
    public void user_navigates_to_heroku() {
        herokuPages.open();
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
        assertThat(herokuPages.userIsLoggedIn()).isTrue();
    }

    @And("User logs out")
    public void logoutUser() {
        herokuPages.logout();
    }


}
