package pages;


import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuPage extends AppiumBaseScreen {

    @FindBy(id = "username")
    private WebElement userNameTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(css = "button.radius")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class='button secondary radius']")
    private WebElement logoutButton;

    @Step
    public void navigateToHerokuLogin() {
        navigateToURL("https://the-internet.herokuapp.com/login");
    }
    @Step
    public void enterUsername(String userName) {
        userNameTextbox.sendKeys(userName);
    }
    @Step
    public void enterPassword(String password) {
       passwordTextbox.sendKeys(password);
    }
    @Step
    public void clickLogin() {
        loginButton.click();
//        passwordTextbox.sendKeys("\n"); // Above click isn't working for some reason anymore
    }
    @Step
    public boolean userIsLoggedIn() {
       waitUntilURLContains("secure");
       return pageContainsText("You logged into a secure area!");
    }
    @Step
    public void logout() {
        logoutButton.click();
    }
    @Step
    public boolean userIsLoggedOut() {
        waitUntilURLContains("login");
        return pageContainsText("You logged out of the secure area!");
    }
}
