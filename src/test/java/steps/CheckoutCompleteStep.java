package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;
import pages.InventoryPage;

public class CheckoutCompleteStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CheckoutCompleteStep.class);
    public CheckoutCompleteStep(WebDriver driver) {
        super(driver);
    }

    @Step("Checkout completed successfully")
    public CheckoutComplete checkCompleteTitle(){
        checkoutComplete.getCheckoutCompleteTitle().isDisplayed();

        logger.info("Checkout is completed");
        return checkoutComplete;
    }
}
