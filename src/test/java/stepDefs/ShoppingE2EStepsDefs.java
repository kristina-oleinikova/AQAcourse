package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.testng.Assert;
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

    @When("user clicks login button")
    public void clickLoginButton(){
        loginPage.getLogInButton().click();
    }

    @When("user ads item to basket")
    public void addItemToBasket(){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.getAddToCartButton().click();
    }

    @When("user clicks shopping button")
    public void clickShoppingButton(){
        inventoryPage.getShoppingCartButton().click();
    }

    @When ("user clicks checkout button")
    public void clickCheckoutButton(){
        cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }

    @When ("user enters firstName {} lastName {} and zipCode {}")
    public void fillForm(String firstName, String lastName, String zipCode){
        checkoutAddInformation = new CheckoutAddInformation(driver);
        checkoutAddInformation.getFirstNameInput().sendKeys(firstName);
        checkoutAddInformation.getLastNameInput().sendKeys(lastName);
        checkoutAddInformation.getPostalCodeInput().sendKeys(zipCode);
    }

    @When("user clicks continue button")
    public void clickContinueButton(){
        checkoutAddInformation.getContinueButton().click();
    }

    @When("user clicks finish button")
    public void clickFinishButton(){
        checkoutOverview =new CheckoutOverview(driver);
        checkoutOverview.getFinishButton().click();
    }

    @Then("CheckoutComplete page is displayed")
    public void isCheckoutCompletePageDisplayed(){
        Assert.assertTrue(new CheckoutComplete(driver).isPageOpened());
    }
}
