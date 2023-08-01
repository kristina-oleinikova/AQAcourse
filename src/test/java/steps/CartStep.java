package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutAddInformation;

public class CartStep extends BaseStep {
    public CartStep(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Checkout' button to start the process")
    public CheckoutAddInformation clickCheckout(){
        cartPage.getCheckoutButton().click();
        return checkoutAddInformation;
    }
}
