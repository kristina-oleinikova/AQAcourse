package steps;

import baseEntities.BaseStep;
import baseEntities.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;

public class InventoryAddItemStep extends BaseStep {
    public InventoryAddItemStep(WebDriver driver) {
        super(driver);
    }

    @Step("Add item to basket")
    public InventoryPage addItemToBasket(){
        inventoryPage.getAddToCartButton().click();
        return inventoryPage;
    }

    @Step("Click on Basket icon to navigate to Cart page")
    public CartPage openCart(){
        inventoryPage.getShoppingCartButton().click();
        return cartPage;
    }
}
