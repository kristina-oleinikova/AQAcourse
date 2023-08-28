package steps;

import baseEntities.BaseStep;
import baseEntities.BaseTest;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryAddItemStep extends BaseStep {
    static Logger logger = LogManager.getLogger(InventoryAddItemStep.class);
    public InventoryAddItemStep() {
        super();
    }

    @Step("Add item to basket")
    public InventoryPage addItemToBasket(){
        inventoryPage.getAddToCartButton().click();

        logger.info("Item is added to basket");
        return inventoryPage;
    }

    @Step("Click on Basket icon to navigate to Cart page")
    public CartPage openCart(){
        inventoryPage.getShoppingCartButton().click();

        logger.info("Cart page is opened");
        return cartPage;
    }
}
