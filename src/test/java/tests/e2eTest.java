package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class e2eTest extends BaseTest {

    @Test
    public void e2eTest(){
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageOpened());
        Assert.assertTrue(inventoryAddItemStep.addItemToBasket().isPageOpened());
        Assert.assertTrue(inventoryAddItemStep.openCart().isPageOpened());
        Assert.assertTrue(cartStep.clickCheckout().isPageOpened());
        Assert.assertTrue(checkoutAddInformationStep.fillFormWithValidData().isPageOpened());
        Assert.assertTrue(checkoutAddInformationStep.continueCheckout().isPageOpened());
        Assert.assertTrue(checkoutOverviewStep.clickFinish().isPageOpened());
        Assert.assertTrue(checkoutCompleteStep.clickComplete().isPageOpened());
    }
}
