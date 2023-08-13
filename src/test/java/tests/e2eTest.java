package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutComplete;
import pages.LoginPage;

public class e2eTest extends BaseTest {

    @Test(description = "E2E test BUY PRODUCT")
    @Description("Test is verified the full flow of buying a product at Platform")
    @Severity(SeverityLevel.CRITICAL)
    public void e2eTest(){
        new LoginPage(driver)
                .successLogin()
                .addItemToBasket()
                .openCart()
                .clickCheckout()
                .fillFormWithValidData()
                .continueCheckout()
                .clickFinish();

        Assert.assertEquals(
                new CheckoutComplete(driver).checkCompleteTitle().checkoutCompleteTitle.getText(),
                "Checkout: Complete!",
                "Wrong Complete page"
        );
    }
}
