package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.xpath("//div [@class='error-message-container error']");

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getUsernameInput() {
        return driver.findElement(usernameInputLocator);
    }

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessageLocator);
    }

    public void setEmail(String value) {
        getUsernameInput().sendKeys(value);
    }


    // Блок комплексных методов
    public void login(String username, String psw) {
        setEmail(username);
        getPswInput().sendKeys(psw);
        getLogInButton().click();
    }
}
