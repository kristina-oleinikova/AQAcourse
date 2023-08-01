package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutAddInformation;
import pages.CheckoutOverview;

public class CheckoutAddInformationStep extends BaseStep {
    public CheckoutAddInformationStep(WebDriver driver) {
        super(driver);
    }

    @Step("Fill the form with valid data")
    public CheckoutAddInformation fillFormWithValidData(){
        checkoutAddInformation.addInfoInForm("1234","1234","1234");
        return checkoutAddInformation;
    }

    @Step("Submit the form")
    public CheckoutOverview continueCheckout(){
        checkoutAddInformation.getContinueButton().click();
        return checkoutOverview;
    }
}
