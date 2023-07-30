package pages;

import baseEntities.BasePage;
import net.bytebuddy.asm.MemberSubstitution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class LoginPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By emailInputLocator = By.id("name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");
    private final By errorFieldTextLocator = By.className("loginpage-message");

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return waitService.waitForExists(emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitService.waitForExists(pswInputLocator);
    }

    public boolean isPswInputDisplayed() {
        return waitService.waitForVisibility(getPswInput()).isDisplayed();
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

    public void setEmail(String value) {
        getEmailInput().sendKeys(value);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }

    public WebElement getErrorFieldTextElement() {
        return driver.findElement(errorFieldTextLocator);
    }

    // Блок комплексных методов
    public void login(String username, String psw) {
        setEmail(username);
        getPswInput().sendKeys(psw);
        getLogInButton().click();
    }
}
