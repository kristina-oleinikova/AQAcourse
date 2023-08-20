package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CheckoutAddInformation;

public class CartStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CartStep.class);
    public CartStep() {
        super();
    }

    @Step("Click on 'Checkout' button to start the process")
    public CheckoutAddInformation clickCheckout(){
        cartPage.getCheckoutButton().click();

        logger.info("User is redirected to first step of Checkout: Add Information page");
        return checkoutAddInformation;
    }
}
