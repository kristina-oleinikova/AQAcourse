package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Login with valid credentials")
    public InventoryPage successLogin(User user) {
        loginPage.login(user);

        return inventoryPage;
    }

    @Step("Login with invalid credentials")
    public LoginPage negativeLogin(User user) {
        loginPage.login(user);

        return loginPage;
    }
}
