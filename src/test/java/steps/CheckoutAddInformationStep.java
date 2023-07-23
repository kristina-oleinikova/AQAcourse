package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutAddInformation;
import pages.CheckoutOverview;

public class CheckoutAddInformationStep extends BaseStep {
    public CheckoutAddInformationStep(WebDriver driver) {
        super(driver);
    }

    public CheckoutAddInformation fillFormWithValidData(){
        checkoutAddInformation.addInfoInForm();
        return checkoutAddInformation;
    }

    public CheckoutOverview continueCheckout(){
        checkoutAddInformation.getContinueButton().click();
        return checkoutOverview;
    }
}
