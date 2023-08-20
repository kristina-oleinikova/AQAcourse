package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import steps.*;
import utils.configuration.ReadProperties;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    static Logger logger = Logger.getLogger(BaseTest.class);

    protected LoginStep loginStep;
    protected InventoryAddItemStep inventoryAddItemStep;
    protected CartStep cartStep;
    protected CheckoutAddInformationStep checkoutAddInformationStep;
    protected CheckoutOverviewStep checkoutOverviewStep;
    protected CheckoutCompleteStep checkoutCompleteStep;

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        org.apache.log4j.BasicConfigurator.configure();

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 8000;
        //Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        //Configuration.assertionMode = SOFT;

        loginStep = new LoginStep();
        inventoryAddItemStep = new InventoryAddItemStep();
        cartStep = new CartStep();
        checkoutAddInformationStep = new CheckoutAddInformationStep();
        checkoutOverviewStep = new CheckoutOverviewStep();
        checkoutCompleteStep = new CheckoutCompleteStep();

        open("/");

        logger.info("Browser is started");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
