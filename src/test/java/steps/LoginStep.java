package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage successLogin(String username, String psw) {
        loginPage.login(username, psw);

        return inventoryPage;
    }

    public LoginPage negativeLogin(String username, String psw) {
        loginPage.login(username, psw);

        return loginPage;
    }
}
