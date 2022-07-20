package Pages;


import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuPages extends AppiumBaseScreen {

    @FindBy(id = "username")
    private WebElement userNameTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(css = "button.radius")
    private WebElement loginButton;
    @FindBy(linkText = "logout")
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
}
