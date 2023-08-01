package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Login with valid credentials")
    public InventoryPage successLogin(String username, String psw) {
        loginPage.login(username, psw);

        return inventoryPage;
    }

    @Step("Login with invalid credentials")
    public LoginPage negativeLogin(String username, String psw) {
        loginPage.login(username, psw);

        return loginPage;
    }
}
