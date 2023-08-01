package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CheckoutComplete;

public class CheckoutOverviewStep extends BaseStep {
    public CheckoutOverviewStep(WebDriver driver) {
        super(driver);
    }

    @Step("Overview order details & click on 'Finish' button")
    public CheckoutComplete clickFinish(){
        checkoutOverview.getFinishButton().click();
        return checkoutComplete;
    }
}
