package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class e2eTest extends BaseTest {

    @Test(description = "E2E test BUY PRODUCT")
    @Description("Test is verified the full flow of buying a product at Platform")
    @Severity(SeverityLevel.CRITICAL)
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
