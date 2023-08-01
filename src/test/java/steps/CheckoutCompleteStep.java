package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;
import pages.InventoryPage;

public class CheckoutCompleteStep extends BaseStep {
    public CheckoutCompleteStep(WebDriver driver) {
        super(driver);
    }

    @Step("Checkout completed successfully")
    public CheckoutComplete checkCompleteTitle(){
        checkoutComplete.getCheckoutCompleteTitle().isDisplayed();
        return checkoutComplete;
    }
}
