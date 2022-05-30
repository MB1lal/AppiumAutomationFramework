package Pages;


import driver.DriverBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HerokuPages extends DriverBase {

    private static AppiumDriver driver;
    By userNameTextbox = By.id("username");
    By passwordTextbox = By.id("password");
    By loginButton = By.cssSelector("button.radius");

    public HerokuPages() {
        driver = getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String userName) {
        driver.findElement(userNameTextbox).click();
//        driver.getKeyboard().sendKeys(userName);
        driver.findElement(userNameTextbox).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextbox).click();
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean userIsLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("secure"));

        return driver.getPageSource().contains("You logged into a secure area!");
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }
}
