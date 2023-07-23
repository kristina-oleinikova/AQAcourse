package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;

public class CheckoutOverviewStep extends BaseStep {
    public CheckoutOverviewStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutComplete clickFinish(){
        checkoutOverview.getFinishButton().click();
        return checkoutComplete;
    }
}
