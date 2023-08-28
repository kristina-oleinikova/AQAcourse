package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.CheckoutComplete;

public class CheckoutCompleteStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CheckoutCompleteStep.class);
    public CheckoutCompleteStep() {
        super();
    }

    @Step("Checkout completed successfully")
    public CheckoutComplete checkCompleteTitle(){
        checkoutComplete.getCheckoutCompleteTitle().isDisplayed();

        logger.info("Checkout is completed");
        return checkoutComplete;
    }
}
