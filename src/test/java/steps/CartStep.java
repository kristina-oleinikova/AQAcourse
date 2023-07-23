package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutAddInformation;

public class CartStep extends BaseStep {
    public CartStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutAddInformation clickCheckout(){
        cartPage.getCheckoutButton().click();
        return checkoutAddInformation;
    }
}
