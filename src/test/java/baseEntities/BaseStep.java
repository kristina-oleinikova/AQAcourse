package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutAddInformation checkoutAddInformation;
    protected CheckoutOverview checkoutOverview;
    protected CheckoutComplete checkoutComplete;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutAddInformation = new CheckoutAddInformation(driver);
        checkoutOverview = new CheckoutOverview(driver);
        checkoutComplete = new CheckoutComplete(driver);
    }
}
