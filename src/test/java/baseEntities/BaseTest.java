package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutAddInformation;
import pages.CheckoutComplete;
import pages.CheckoutOverview;
import steps.*;
import utils.configuration.ReadProperties;

@Listeners(InvokedListener.class)
//@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected InventoryAddItemStep inventoryAddItemStep;
    protected CartStep cartStep;
    protected CheckoutAddInformationStep checkoutAddInformationStep;
    protected CheckoutOverviewStep checkoutOverviewStep;
    protected CheckoutCompleteStep checkoutCompleteStep;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        loginStep = new LoginStep(driver);
        inventoryAddItemStep = new InventoryAddItemStep(driver);
        cartStep = new CartStep(driver);
        checkoutAddInformationStep = new CheckoutAddInformationStep(driver);
        checkoutOverviewStep = new CheckoutOverviewStep(driver);
        checkoutCompleteStep = new CheckoutCompleteStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
