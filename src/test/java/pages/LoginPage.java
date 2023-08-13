package pages;

import baseEntities.BasePage;
import helper.DataHelper;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания локаторов для элементов
    @FindBy(id ="user-name")
    public WebElement usernameInput;

    @FindBy(id ="password")
    public WebElement pswInput;

    @FindBy(id = "login-button")
    public WebElement logInButton;

    @FindBy(xpath = "//div [@class='error-message-container error']")
    public WebElement errorMessage;

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("button_primary");
    }


    @Step("Login with valid credentials")
    public InventoryPage successLogin() {
        login();

        return new InventoryPage(driver);
    }

    public InventoryPage successLogin(User user) {
        login(user);

        return new InventoryPage(driver);
    }

    public LoginPage negativeLogin() {
        login();

        return this;
    }

    public LoginPage negativeLogin(User user) {
        login(user);

        return this;
    }


    // Блок комплексных методов
    public void login() {
        usernameInput.sendKeys(DataHelper.getStandartUser().getUsername());
        pswInput.sendKeys(DataHelper.getStandartUser().getPassword());
        logInButton.click();
    }

    public void login(User user) {
        usernameInput.sendKeys(user.getUsername());
        pswInput.sendKeys(user.getPassword());
        logInButton.click();
    }

}
