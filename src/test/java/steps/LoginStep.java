package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    static Logger logger = LogManager.getLogger(LoginStep.class);

    public LoginStep() {
        super();
    }

    @Step("Login with valid credentials")
    public InventoryPage successLogin(User user) {
        loginPage.login(user);

        logger.info("User is successfully logged in to Platform");
        return inventoryPage;
    }

    @Step("Login with invalid credentials")
    public LoginPage negativeLogin(User user) {
        loginPage.login(user);

        logger.info("Unsuccessful login");
        return loginPage;
    }
}
