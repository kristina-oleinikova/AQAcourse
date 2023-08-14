package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CheckoutAddInformation;

public class CartStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CartStep.class);
    public CartStep(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Checkout' button to start the process")
    public CheckoutAddInformation clickCheckout(){
        cartPage.getCheckoutButton().click();

        logger.info("User is redirected to first step of Checkout: Add Information page");
        return checkoutAddInformation;
    }
}
