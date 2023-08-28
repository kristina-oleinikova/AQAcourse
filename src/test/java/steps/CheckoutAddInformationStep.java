package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.CheckoutAddInformation;
import pages.CheckoutOverview;

public class CheckoutAddInformationStep extends BaseStep {
    static Logger logger = LogManager.getLogger(CheckoutAddInformationStep.class);
    public CheckoutAddInformationStep() {
        super();
    }

    @Step("Fill the form with valid data")
    public CheckoutAddInformation fillFormWithValidData(){
        checkoutAddInformation.addInfoInForm("1234","1234","1234");

        logger.info("Form is filled with valid data");
        return checkoutAddInformation;
    }

    @Step("Submit the form")
    public CheckoutOverview continueCheckout(){
        checkoutAddInformation.getContinueButton().click();

        logger.info("User is redirected to second step of Checkout: Checkout Overview page");
        return checkoutOverview;
    }
}
