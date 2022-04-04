package Pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HerokuPages {

    private AppiumDriver driver;

    By userNameTextbox = By.cssSelector("input#username");
    By passwordTextbox = By.cssSelector("input#password");
    By loginButton = By.cssSelector("button.radius");

    public HerokuPages(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String userName) {
        driver.findElement(userNameTextbox).click();
        driver.getKeyboard().sendKeys(userName);
//        driver.findElement(userNameTextbox).sendKeys(userName);
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
