package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.xpath("//div [@class='error-message-container error']");

    // Блок инициализации
    public LoginPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // Блок атомарных методов
    public SelenideElement getUsernameInput() {
        return $(usernameInputLocator);
    }

    public SelenideElement getPswInput() {
        return $(pswInputLocator);
    }

    public SelenideElement getLogInButton() {
        return $(logInButtonLocator);
    }

    public SelenideElement getErrorMessage() {
        return $(errorMessageLocator);
    }

    public void setEmail(String value) {
        getUsernameInput().sendKeys(value);
    }


    // Блок комплексных методов
    public void login(User user) {
        setEmail(user.getUsername());
        getPswInput().sendKeys(user.getPassword());
        getLogInButton().click();
    }
}
