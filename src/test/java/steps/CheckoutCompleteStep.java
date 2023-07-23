package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;
import pages.InventoryPage;

public class CheckoutCompleteStep extends BaseStep {
    public CheckoutCompleteStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutComplete checkCompleteTitle(){
        checkoutComplete.getCheckoutCompleteTitle().isDisplayed();
        return checkoutComplete;
    }
}
