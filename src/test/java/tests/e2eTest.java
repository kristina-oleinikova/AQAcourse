package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class e2eTest extends BaseTest {

    @Test
    public void e2eTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageOpened();
        inventoryAddItemStep.addItemToBasket().getHeaderTitle().isDisplayed();
        inventoryAddItemStep.openCart().getCheckoutButton().isDisplayed();
        cartStep.clickCheckout().getContinueButton().isDisplayed();
        checkoutAddInformationStep.fillFormWithValidData();
        checkoutAddInformationStep.continueCheckout().getFinishButton().isDisplayed();
        checkoutOverviewStep.clickFinish();

        Assert.assertEquals(
                checkoutCompleteStep.checkCompleteTitle().getCheckoutCompleteTitle().getText(),
                "Checkout: Complete!",
                "Wrong Complete page"
        );
    }
}
