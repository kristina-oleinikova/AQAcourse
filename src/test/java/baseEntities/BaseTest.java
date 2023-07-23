package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.CheckoutAddInformation;
import pages.CheckoutComplete;
import pages.CheckoutOverview;
import steps.*;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected InventoryAddItemStep inventoryAddItemStep;
    protected CartStep cartStep;
    protected CheckoutAddInformationStep checkoutAddInformationStep;
    protected CheckoutOverviewStep checkoutOverviewStep;
    protected CheckoutCompleteStep checkoutCompleteStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginStep = new LoginStep(driver);
        inventoryAddItemStep = new InventoryAddItemStep(driver);
        cartStep = new CartStep(driver);
        checkoutAddInformationStep = new CheckoutAddInformationStep(driver);
        checkoutOverviewStep = new CheckoutOverviewStep(driver);
        checkoutCompleteStep = new CheckoutCompleteStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
