package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.User;
import pages.*;
import utils.configuration.ReadProperties;

public class ShoppingE2EStepsDefs extends BaseTest {
    private BaseTest baseTest;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutOverview checkoutOverview;
    private CheckoutAddInformation checkoutAddInformation;
    private CheckoutComplete checkoutComplete;

    public ShoppingE2EStepsDefs(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("start browser")
    public void startBrowser() {
    }
    @Given("open login page")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }


    @When("user enters username {} and password {}")
    public void successfulLogin(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPswInput().sendKeys(password);
    }
}
