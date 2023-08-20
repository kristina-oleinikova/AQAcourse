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

    public BaseStep() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutAddInformation = new CheckoutAddInformation();
        checkoutOverview = new CheckoutOverview();
        checkoutComplete = new CheckoutComplete();
    }
}
