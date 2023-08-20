package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CheckoutComplete;

public class CheckoutOverviewStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CheckoutOverviewStep.class);
    public CheckoutOverviewStep() {
        super();
    }

    @Step("Overview order details & click on 'Finish' button")
    public CheckoutComplete clickFinish(){
        checkoutOverview.getFinishButton().click();

        logger.info("User is redirected to final step of Checkout: Checkout Complete page");
        return checkoutComplete;
    }
}
